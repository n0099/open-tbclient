package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl bRp;
    private a cTQ;
    private c grF;
    private b grG;
    private int grD = PushConstants.WORK_RECEIVER_EVENTCORE_ERROR;
    private int grE = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.bRp != null && j.this.bRp.isPlaying()) {
                int currentPosition = j.this.bRp.getCurrentPosition();
                int duration = j.this.bRp.getDuration();
                if (currentPosition < j.this.grE) {
                    if (j.this.cTQ != null) {
                        j.this.cTQ.akr();
                    }
                } else if (currentPosition == j.this.grE && j.this.grF != null) {
                    j.this.grF.Wg();
                }
                if (j.this.grG != null) {
                    j.this.grG.cA(duration, currentPosition);
                }
                j.this.grE = currentPosition;
                j.this.bjZ();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void akr();
    }

    /* loaded from: classes.dex */
    public interface b {
        void cA(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void Wg();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bRp = mediaPlayerControl;
    }

    public void start() {
        this.grE = 0;
        bjZ();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjZ() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.grD);
    }

    public void a(a aVar) {
        this.cTQ = aVar;
    }

    public void a(c cVar) {
        this.grF = cVar;
    }
}
