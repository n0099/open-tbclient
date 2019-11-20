package com.baidu.tieba.livesdk.h;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ala.helper.AlaLiveDebugInfo;
import com.baidu.ala.livePlayer.AlaLivePlayer;
import com.baidu.ala.livePlayer.AlaLivePlayerCallback;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.live.liveroom.d.c;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b implements com.baidu.live.liveroom.d.a {
    private boolean aiJ;
    private int hkd = 1;
    private int hke = -1;
    private c hkf;
    private AlaLivePlayer hkg;
    private Uri mUri;

    public b(Context context) {
        if (this.hkg == null) {
            this.hkg = AlaLivePlayer.createLivePlayer(context);
        }
        BdLog.e("TbLivePlayerImpl init()" + this.hkg);
    }

    @Override // com.baidu.live.liveroom.d.a
    public void d(Context context, Uri uri) {
        if (this.hkg == null) {
            this.hkg = AlaLivePlayer.createLivePlayer(context);
        }
        this.mUri = uri;
        BdLog.e("TbLivePlayerImpl=" + this.hkg + "|mUri=" + this.mUri);
    }

    @Override // com.baidu.live.liveroom.d.a
    public void a(c cVar) {
        this.hkf = cVar;
        this.hkg.setPlayerCallback(new AlaLivePlayerCallback() { // from class: com.baidu.tieba.livesdk.h.b.1
            @Override // com.baidu.ala.livePlayer.AlaLivePlayerCallback
            public void onStreamChanged(int i, int i2) {
            }

            @Override // com.baidu.ala.livePlayer.AlaLivePlayerCallback
            public void onDebugInfo(int i, AlaLiveDebugInfo alaLiveDebugInfo) {
            }

            @Override // com.baidu.ala.livePlayer.AlaLivePlayerCallback
            public void onBufferingEvent(int i, int i2, long j, int i3) {
            }

            @Override // com.baidu.ala.livePlayer.AlaLivePlayerCallback
            public void onFrameDelay(int i, int i2, int i3) {
            }

            @Override // com.baidu.ala.livePlayer.AlaLivePlayerCallback
            public void onFirstFrame(int i, int i2, int i3) {
                if (b.this.hkf != null) {
                    b.this.hkf.a(b.this, CyberPlayerManager.MEDIA_INFO_FIRST_DISP_INTERVAL, i);
                }
                BdLog.e("TbLivePlayerImpl onFirstFrame()" + i);
            }

            @Override // com.baidu.ala.livePlayer.AlaLivePlayerCallback
            public void onStreamStuck(int i, int i2, int i3) {
            }

            @Override // com.baidu.ala.livePlayer.AlaLivePlayerCallback
            public void onFastOpen(int i, int i2) {
            }
        });
    }

    @Override // com.baidu.live.liveroom.d.a
    public void setDecodeMode(int i) {
    }

    @Override // com.baidu.live.liveroom.d.a
    public void b(int i, JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.hke == -1) {
                this.hke = i;
            }
            if (this.hkg != null) {
                this.hkg.setStatConfigBeforeStart(TbadkCoreApplication.getInst().getApp().getFilesDir().getAbsolutePath() + "/live_sdk_log/", "http://c.tieba.baidu.com/ala/sys/mlog", com.baidu.live.l.a.uB().ajF.QG);
                this.hkg.setStartInfo(i, jSONObject.optString("LIVE_ID"), jSONObject.optString("SESSION_ID"), jSONObject.optString("CLIENT_IP"), jSONObject.optString("LEVEL"), jSONObject.optInt("SESSION_LINE"), TbConfig.getSubappType());
            }
        }
    }

    @Override // com.baidu.live.liveroom.d.a
    public View uh() {
        return this.hkg;
    }

    @Override // com.baidu.live.liveroom.d.a
    public void bz(int i) {
    }

    @Override // com.baidu.live.liveroom.d.a
    public void b(Uri uri) {
        this.mUri = uri;
    }

    @Override // com.baidu.live.liveroom.d.a
    public void setVideoScalingMode(int i) {
        if (this.hkg != null) {
            this.hkg.setRenderVideoModel(this.hke, 1);
        }
    }

    @Override // com.baidu.live.liveroom.d.a
    public void start() {
        if (this.hke == -1) {
            this.hke = 1;
        }
        if (this.hkd == 3) {
            this.hkg.resume();
            this.hkd = 2;
            return;
        }
        AlaLivePlayer.AlaLivePlayerConf alaLivePlayerConf = new AlaLivePlayer.AlaLivePlayerConf();
        alaLivePlayerConf.index = this.hke;
        alaLivePlayerConf.url = this.mUri.toString();
        alaLivePlayerConf.param = new LinearLayout.LayoutParams(-1, -1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(alaLivePlayerConf);
        this.hkg.start2(arrayList);
        this.hkd = 2;
        BdLog.e("TbLivePlayerImpl start() mUri=" + this.mUri + "|index=" + this.hke);
        this.aiJ = true;
    }

    @Override // com.baidu.live.liveroom.d.a
    public void pause() {
        if (this.hkg != null) {
            this.hkg.pause();
            this.hkd = 3;
        }
        BdLog.e("TbLivePlayerImpl pause() mUri=" + this.mUri);
        this.aiJ = false;
    }

    @Override // com.baidu.live.liveroom.d.a
    public void stop() {
        if (this.hkg != null) {
            this.hkg.stop();
            this.hkd = 4;
        }
        BdLog.e("TbLivePlayerImpl stop() mUri=" + this.mUri);
        this.aiJ = false;
    }

    @Override // com.baidu.live.liveroom.d.a
    public void release() {
        if (this.hkg != null) {
            this.hkg.stop();
            this.hkg.destroy();
            this.hkd = 4;
        }
        BdLog.e("TbLivePlayerImpl release() mUri=" + this.mUri);
        this.aiJ = false;
    }
}
