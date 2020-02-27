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
    private AlaLivePlayer idJ;
    private volatile d.a idK;
    private WeakReference<Context> mContext;
    private AlaLivePlayerData idL = new AlaLivePlayerData();
    private AlaLivePlayerCallback mPlayerCallback = new AlaLivePlayerCallback() { // from class: com.baidu.tieba.livesdk.i.a.1
        @Override // com.baidu.ala.player.AlaLivePlayerCallback
        public void onStreamChanged(int i, int i2) {
            BdLog.d("onStreamChanged index = " + i + " statucCode = " + i2);
        }

        @Override // com.baidu.ala.player.AlaLivePlayerCallback
        public void onDebugInfo(int i, AlaLiveDebugInfo alaLiveDebugInfo) {
            BdLog.d("onDebugInfo");
            if (a.this.idK != null && alaLiveDebugInfo != null) {
                a.this.idL.bandWidth = alaLiveDebugInfo.bandWidth;
                a.this.idL.fpsAvg = alaLiveDebugInfo.fpsAvg;
                a.this.idL.videoBitrate = alaLiveDebugInfo.bandWidth;
                a.this.idL.audioBitrate = 65536L;
                a.this.idK.a(i, a.this.idL);
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
            if (a.this.idK != null) {
                a.this.idK.onFirstFrame(i, i2, i3);
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
        this.idJ = AlaLivePlayer.createLivePlayer(context);
        this.idJ.setPlayerCallback(this.mPlayerCallback);
    }

    @Override // com.baidu.tbadk.ala.d
    public boolean a(int i, String str, LinearLayout.LayoutParams layoutParams) {
        if (this.idJ == null) {
            BdLog.d("AlaPlayerWrap start failed");
            return false;
        }
        ArrayList arrayList = new ArrayList();
        AlaLivePlayer.AlaLivePlayerConf alaLivePlayerConf = new AlaLivePlayer.AlaLivePlayerConf();
        alaLivePlayerConf.index = i;
        alaLivePlayerConf.url = str;
        alaLivePlayerConf.param = layoutParams;
        arrayList.add(alaLivePlayerConf);
        int start2 = this.idJ.start2(arrayList);
        if (start2 != 0) {
            BdLog.d("prepareAsync failed");
        }
        return start2 == 0;
    }

    @Override // com.baidu.tbadk.ala.d
    public void stop() {
        if (this.idJ == null) {
            BdLog.d("AlaPlayerWrap stop mPlayer = null");
        } else {
            this.idJ.stop();
        }
    }

    @Override // com.baidu.tbadk.ala.d
    public void destroy() {
        if (this.idJ == null) {
            BdLog.d("AlaPlayerWrap destroy mPlayer = null");
            return;
        }
        this.idJ.destroy();
        this.idJ = null;
    }

    @Override // com.baidu.tbadk.ala.d
    public void setAudioMute(boolean z) {
        if (this.idJ == null) {
            BdLog.d("AlaPlayerWrap setAudioMute mPlayer = null");
        } else {
            this.idJ.setAudioMute(z);
        }
    }

    @Override // com.baidu.tbadk.ala.d
    public void setRenderVideoModel(int i, int i2) {
        if (this.idJ == null) {
            BdLog.d("AlaPlayerWrap setRenderVideoModel mPlayer = null");
        } else {
            this.idJ.setRenderVideoModel(i, i2);
        }
    }

    @Override // com.baidu.tbadk.ala.d
    public View ayA() {
        if (this.idJ == null) {
            BdLog.d("AlaPlayerWrap getRenderView mPlayer = null");
            return null;
        }
        return this.idJ;
    }

    @Override // com.baidu.tbadk.ala.d
    public void a(d.a aVar) {
        this.idK = aVar;
    }
}
