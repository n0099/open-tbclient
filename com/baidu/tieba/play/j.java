package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl bTC;
    private a cWU;
    private c gtG;
    private b gtH;
    private int gtE = PushConstants.WORK_RECEIVER_EVENTCORE_ERROR;
    private int gtF = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.bTC != null && j.this.bTC.isPlaying()) {
                int currentPosition = j.this.bTC.getCurrentPosition();
                int duration = j.this.bTC.getDuration();
                if (currentPosition < j.this.gtF) {
                    if (j.this.cWU != null) {
                        j.this.cWU.alf();
                    }
                } else if (currentPosition == j.this.gtF && j.this.gtG != null) {
                    j.this.gtG.WZ();
                }
                if (j.this.gtH != null) {
                    j.this.gtH.cw(duration, currentPosition);
                }
                j.this.gtF = currentPosition;
                j.this.bln();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void alf();
    }

    /* loaded from: classes.dex */
    public interface b {
        void cw(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void WZ();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bTC = mediaPlayerControl;
    }

    public void start() {
        this.gtF = 0;
        bln();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bln() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.gtE);
    }

    public void a(a aVar) {
        this.cWU = aVar;
    }

    public void a(c cVar) {
        this.gtG = cVar;
    }
}
