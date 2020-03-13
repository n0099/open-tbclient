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
/* loaded from: classes3.dex */
public class c implements com.baidu.live.liveroom.e.a {
    private int fjH = 1;
    private int fjI = -1;
    private AlaLivePlayer fjJ;
    private com.baidu.live.liveroom.e.c ieb;
    private boolean isPlaying;
    private Uri mUri;

    public c(Context context) {
        if (this.fjJ == null) {
            this.fjJ = AlaLivePlayer.createLivePlayer(context);
        }
        BdLog.e("TbLivePlayerImpl init()" + this.fjJ);
    }

    @Override // com.baidu.live.liveroom.e.a
    public void d(Context context, Uri uri) {
        if (this.fjJ == null) {
            this.fjJ = AlaLivePlayer.createLivePlayer(context);
        }
        this.mUri = uri;
        BdLog.e("TbLivePlayerImpl=" + this.fjJ + "|mUri=" + this.mUri);
    }

    @Override // com.baidu.live.liveroom.e.a
    public void a(com.baidu.live.liveroom.e.c cVar) {
        this.ieb = cVar;
        if (this.fjJ != null) {
            this.fjJ.setPlayerCallback(new AlaLivePlayerCallback() { // from class: com.baidu.tieba.livesdk.i.c.1
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
                    if (c.this.ieb != null) {
                        c.this.ieb.a(c.this, CyberPlayerManager.MEDIA_INFO_FIRST_DISP_INTERVAL, i);
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
    }

    @Override // com.baidu.live.liveroom.e.a
    public void setDecodeMode(int i) {
    }

    @Override // com.baidu.live.liveroom.e.a
    public void b(int i, JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.fjI == -1) {
                this.fjI = i;
            }
            if (this.fjJ != null) {
                this.fjJ.setStatConfigBeforeStart(TbadkCoreApplication.getInst().getApp().getFilesDir().getAbsolutePath() + "/live_sdk_log/", "http://c.tieba.baidu.com/ala/sys/mlog", com.baidu.live.v.a.zl().awC.ZF);
                this.fjJ.setStartInfo(i, jSONObject.optString("LIVE_ID"), jSONObject.optString("SESSION_ID"), jSONObject.optString("CLIENT_IP"), jSONObject.optString("LEVEL"), jSONObject.optInt("SESSION_LINE"), TbConfig.getSubappType());
            }
        }
    }

    @Override // com.baidu.live.liveroom.e.a
    public View getPlayerView() {
        return this.fjJ;
    }

    @Override // com.baidu.live.liveroom.e.a
    public void cf(int i) {
    }

    @Override // com.baidu.live.liveroom.e.a
    public void c(Uri uri) {
        this.mUri = uri;
    }

    @Override // com.baidu.live.liveroom.e.a
    public void setVideoScalingMode(int i) {
        if (this.fjJ != null) {
            this.fjJ.setRenderVideoModel(this.fjI, 1);
        }
    }

    @Override // com.baidu.live.liveroom.e.a
    public void start() {
        if (this.fjI == -1) {
            this.fjI = 1;
        }
        if (this.fjH == 3) {
            this.fjJ.resume();
            this.fjH = 2;
            return;
        }
        AlaLivePlayer.AlaLivePlayerConf alaLivePlayerConf = new AlaLivePlayer.AlaLivePlayerConf();
        alaLivePlayerConf.index = this.fjI;
        alaLivePlayerConf.url = this.mUri.toString();
        alaLivePlayerConf.param = new LinearLayout.LayoutParams(-1, -1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(alaLivePlayerConf);
        this.fjJ.start2(arrayList);
        this.fjH = 2;
        BdLog.e("TbLivePlayerImpl start() mUri=" + this.mUri + "|index=" + this.fjI);
        this.isPlaying = true;
    }

    @Override // com.baidu.live.liveroom.e.a
    public void stop() {
        if (this.fjJ != null) {
            this.fjJ.stop();
            this.fjH = 4;
        }
        BdLog.e("TbLivePlayerImpl stop() mUri=" + this.mUri);
        this.isPlaying = false;
    }

    @Override // com.baidu.live.liveroom.e.a
    public void release() {
        if (this.fjJ != null) {
            this.fjJ.stop();
            this.fjJ.destroy();
            this.fjH = 4;
        }
        BdLog.e("TbLivePlayerImpl release() mUri=" + this.mUri);
        this.isPlaying = false;
    }
}
