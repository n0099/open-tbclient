package com.baidu.tieba.livesdk.i;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ala.helper.AlaLiveDebugInfo;
import com.baidu.ala.player.AlaLivePlayer;
import com.baidu.ala.player.AlaLivePlayerCallback;
import com.baidu.tbadk.ala.AlaLivePlayerData;
import com.baidu.tbadk.ala.d;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class a implements d {
    private AlaLivePlayer jUq;
    private volatile d.a jUr;
    private WeakReference<Context> mContext;
    private AlaLivePlayerData jUs = new AlaLivePlayerData();
    private AlaLivePlayerCallback mPlayerCallback = new AlaLivePlayerCallback() { // from class: com.baidu.tieba.livesdk.i.a.1
        @Override // com.baidu.ala.player.AlaLivePlayerCallback
        public void onStreamChanged(int i, int i2) {
            BdLog.d("onStreamChanged index = " + i + " statucCode = " + i2);
        }

        @Override // com.baidu.ala.player.AlaLivePlayerCallback
        public void onDebugInfo(int i, AlaLiveDebugInfo alaLiveDebugInfo) {
            BdLog.d("onDebugInfo");
            if (a.this.jUr != null && alaLiveDebugInfo != null) {
                a.this.jUs.bandWidth = alaLiveDebugInfo.bandWidth;
                a.this.jUs.fpsAvg = alaLiveDebugInfo.fpsAvg;
                a.this.jUs.videoBitrate = alaLiveDebugInfo.bandWidth;
                a.this.jUs.audioBitrate = 65536L;
                a.this.jUr.a(i, a.this.jUs);
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
            if (a.this.jUr != null) {
                a.this.jUr.onFirstFrame(i, i2, i3);
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
        this.jUq = AlaLivePlayer.createLivePlayer(context);
        this.jUq.setPlayerCallback(this.mPlayerCallback);
    }
}
