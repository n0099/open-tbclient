package com.baidu.tieba.livesdk.i;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ala.helper.AlaLiveDebugInfo;
import com.baidu.ala.player.AlaLivePlayer;
import com.baidu.ala.player.AlaLivePlayerCallback;
import com.baidu.tbadk.ala.AlaLivePlayerData;
import com.baidu.tbadk.ala.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a implements d {
    private AlaLivePlayer idL;
    private volatile d.a idM;
    private WeakReference<Context> mContext;
    private AlaLivePlayerData idN = new AlaLivePlayerData();
    private AlaLivePlayerCallback mPlayerCallback = new AlaLivePlayerCallback() { // from class: com.baidu.tieba.livesdk.i.a.1
        @Override // com.baidu.ala.player.AlaLivePlayerCallback
        public void onStreamChanged(int i, int i2) {
            BdLog.d("onStreamChanged index = " + i + " statucCode = " + i2);
        }

        @Override // com.baidu.ala.player.AlaLivePlayerCallback
        public void onDebugInfo(int i, AlaLiveDebugInfo alaLiveDebugInfo) {
            BdLog.d("onDebugInfo");
            if (a.this.idM != null && alaLiveDebugInfo != null) {
                a.this.idN.bandWidth = alaLiveDebugInfo.bandWidth;
                a.this.idN.fpsAvg = alaLiveDebugInfo.fpsAvg;
                a.this.idN.videoBitrate = alaLiveDebugInfo.bandWidth;
                a.this.idN.audioBitrate = 65536L;
                a.this.idM.a(i, a.this.idN);
            }
        }

        @Override // com.baidu.ala.player.AlaLivePlayerCallback
        public void onBufferingEvent(int i, int i2, long j, int i3) {
        }

        @Override // com.baidu.ala.player.AlaLivePlayerCallback
        public void onFrameDelay(int i, int i2, int i3) {
            BdLog.d("onFrameDelay " + i);
        }

        @Override // com.baidu.ala.player.AlaLivePlayerCallback
        public void onFirstFrame(int i, int i2, int i3) {
            BdLog.d("onFirstFrame " + i);
            if (a.this.idM != null) {
                a.this.idM.onFirstFrame(i, i2, i3);
            }
        }

        @Override // com.baidu.ala.player.AlaLivePlayerCallback
        public void onStreamStuck(int i, int i2, int i3) {
        }

        @Override // com.baidu.ala.player.AlaLivePlayerCallback
        public void onFastOpen(int i, int i2) {
            BdLog.d("onFastOpen " + i);
        }
    };

    public a(Context context) {
        this.mContext = new WeakReference<>(context);
        this.idL = AlaLivePlayer.createLivePlayer(context);
        this.idL.setPlayerCallback(this.mPlayerCallback);
    }

    @Override // com.baidu.tbadk.ala.d
    public boolean a(int i, String str, LinearLayout.LayoutParams layoutParams) {
        if (this.idL == null) {
            BdLog.d("AlaPlayerWrap start failed");
            return false;
        }
        ArrayList arrayList = new ArrayList();
        AlaLivePlayer.AlaLivePlayerConf alaLivePlayerConf = new AlaLivePlayer.AlaLivePlayerConf();
        alaLivePlayerConf.index = i;
        alaLivePlayerConf.url = str;
        alaLivePlayerConf.param = layoutParams;
        arrayList.add(alaLivePlayerConf);
        int start2 = this.idL.start2(arrayList);
        if (start2 != 0) {
            BdLog.d("prepareAsync failed");
        }
        return start2 == 0;
    }

    @Override // com.baidu.tbadk.ala.d
    public void stop() {
        if (this.idL == null) {
            BdLog.d("AlaPlayerWrap stop mPlayer = null");
        } else {
            this.idL.stop();
        }
    }

    @Override // com.baidu.tbadk.ala.d
    public void destroy() {
        if (this.idL == null) {
            BdLog.d("AlaPlayerWrap destroy mPlayer = null");
            return;
        }
        this.idL.destroy();
        this.idL = null;
    }

    @Override // com.baidu.tbadk.ala.d
    public void setAudioMute(boolean z) {
        if (this.idL == null) {
            BdLog.d("AlaPlayerWrap setAudioMute mPlayer = null");
        } else {
            this.idL.setAudioMute(z);
        }
    }

    @Override // com.baidu.tbadk.ala.d
    public void setRenderVideoModel(int i, int i2) {
        if (this.idL == null) {
            BdLog.d("AlaPlayerWrap setRenderVideoModel mPlayer = null");
        } else {
            this.idL.setRenderVideoModel(i, i2);
        }
    }

    @Override // com.baidu.tbadk.ala.d
    public View ayC() {
        if (this.idL == null) {
            BdLog.d("AlaPlayerWrap getRenderView mPlayer = null");
            return null;
        }
        return this.idL;
    }

    @Override // com.baidu.tbadk.ala.d
    public void a(d.a aVar) {
        this.idM = aVar;
    }
}
