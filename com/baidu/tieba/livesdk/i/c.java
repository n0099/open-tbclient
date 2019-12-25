package com.baidu.tieba.livesdk.i;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ala.helper.AlaLiveDebugInfo;
import com.baidu.ala.player.AlaLivePlayer;
import com.baidu.ala.player.AlaLivePlayerCallback;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c implements com.baidu.live.liveroom.d.a {
    private int fcY = 1;
    private int fcZ = -1;
    private AlaLivePlayer fda;
    private com.baidu.live.liveroom.d.c hYh;
    private boolean isPlaying;
    private Uri mUri;

    public c(Context context) {
        if (this.fda == null) {
            this.fda = AlaLivePlayer.createLivePlayer(context);
        }
        BdLog.e("TbLivePlayerImpl init()" + this.fda);
    }

    @Override // com.baidu.live.liveroom.d.a
    public void d(Context context, Uri uri) {
        if (this.fda == null) {
            this.fda = AlaLivePlayer.createLivePlayer(context);
        }
        this.mUri = uri;
        BdLog.e("TbLivePlayerImpl=" + this.fda + "|mUri=" + this.mUri);
    }

    @Override // com.baidu.live.liveroom.d.a
    public void a(com.baidu.live.liveroom.d.c cVar) {
        this.hYh = cVar;
        this.fda.setPlayerCallback(new AlaLivePlayerCallback() { // from class: com.baidu.tieba.livesdk.i.c.1
            @Override // com.baidu.ala.player.AlaLivePlayerCallback
            public void onStreamChanged(int i, int i2) {
            }

            @Override // com.baidu.ala.player.AlaLivePlayerCallback
            public void onDebugInfo(int i, AlaLiveDebugInfo alaLiveDebugInfo) {
            }

            @Override // com.baidu.ala.player.AlaLivePlayerCallback
            public void onBufferingEvent(int i, int i2, long j, int i3) {
            }

            @Override // com.baidu.ala.player.AlaLivePlayerCallback
            public void onFrameDelay(int i, int i2, int i3) {
            }

            @Override // com.baidu.ala.player.AlaLivePlayerCallback
            public void onFirstFrame(int i, int i2, int i3) {
                if (c.this.hYh != null) {
                    c.this.hYh.a(c.this, CyberPlayerManager.MEDIA_INFO_FIRST_DISP_INTERVAL, i);
                }
                BdLog.e("TbLivePlayerImpl onFirstFrame()" + i);
            }

            @Override // com.baidu.ala.player.AlaLivePlayerCallback
            public void onStreamStuck(int i, int i2, int i3) {
            }

            @Override // com.baidu.ala.player.AlaLivePlayerCallback
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
            if (this.fcZ == -1) {
                this.fcZ = i;
            }
            if (this.fda != null) {
                this.fda.setStatConfigBeforeStart(TbadkCoreApplication.getInst().getApp().getFilesDir().getAbsolutePath() + "/live_sdk_log/", "http://c.tieba.baidu.com/ala/sys/mlog", com.baidu.live.r.a.wA().arE.Xv);
                this.fda.setStartInfo(i, jSONObject.optString("LIVE_ID"), jSONObject.optString("SESSION_ID"), jSONObject.optString("CLIENT_IP"), jSONObject.optString("LEVEL"), jSONObject.optInt("SESSION_LINE"), TbConfig.getSubappType());
            }
        }
    }

    @Override // com.baidu.live.liveroom.d.a
    public View getPlayerView() {
        return this.fda;
    }

    @Override // com.baidu.live.liveroom.d.a
    public void bQ(int i) {
    }

    @Override // com.baidu.live.liveroom.d.a
    public void b(Uri uri) {
        this.mUri = uri;
    }

    @Override // com.baidu.live.liveroom.d.a
    public void setVideoScalingMode(int i) {
        if (this.fda != null) {
            this.fda.setRenderVideoModel(this.fcZ, 1);
        }
    }

    @Override // com.baidu.live.liveroom.d.a
    public void start() {
        if (this.fcZ == -1) {
            this.fcZ = 1;
        }
        if (this.fcY == 3) {
            this.fda.resume();
            this.fcY = 2;
            return;
        }
        AlaLivePlayer.AlaLivePlayerConf alaLivePlayerConf = new AlaLivePlayer.AlaLivePlayerConf();
        alaLivePlayerConf.index = this.fcZ;
        alaLivePlayerConf.url = this.mUri.toString();
        alaLivePlayerConf.param = new LinearLayout.LayoutParams(-1, -1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(alaLivePlayerConf);
        this.fda.start2(arrayList);
        this.fcY = 2;
        BdLog.e("TbLivePlayerImpl start() mUri=" + this.mUri + "|index=" + this.fcZ);
        this.isPlaying = true;
    }

    @Override // com.baidu.live.liveroom.d.a
    public void stop() {
        if (this.fda != null) {
            this.fda.stop();
            this.fcY = 4;
        }
        BdLog.e("TbLivePlayerImpl stop() mUri=" + this.mUri);
        this.isPlaying = false;
    }

    @Override // com.baidu.live.liveroom.d.a
    public void release() {
        if (this.fda != null) {
            this.fda.stop();
            this.fda.destroy();
            this.fcY = 4;
        }
        BdLog.e("TbLivePlayerImpl release() mUri=" + this.mUri);
        this.isPlaying = false;
    }
}
