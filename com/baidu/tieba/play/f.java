package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class f {
    private MediaController.MediaPlayerControl gju;
    private a iyL;
    private c mJC;
    private b mJD;
    private int mJA = 1000;
    private int mJB = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && f.this.gju != null && f.this.gju.isPlaying()) {
                int currentPosition = f.this.gju.getCurrentPosition();
                int duration = f.this.gju.getDuration();
                if (currentPosition < f.this.mJB) {
                    if (f.this.iyL != null) {
                        f.this.iyL.rD();
                    }
                } else if (currentPosition == f.this.mJB && f.this.mJC != null) {
                    f.this.mJC.bRB();
                }
                if (f.this.mJD != null) {
                    f.this.mJD.cf(duration, currentPosition);
                }
                f.this.mJB = currentPosition;
                f.this.dAh();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void rD();
    }

    /* loaded from: classes.dex */
    public interface b {
        void cf(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void bRB();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.gju = mediaPlayerControl;
    }

    public void start() {
        this.mJB = 0;
        dAh();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAh() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.mJA);
    }

    public void a(a aVar) {
        this.iyL = aVar;
    }

    public void a(c cVar) {
        this.mJC = cVar;
    }

    public void a(b bVar) {
        this.mJD = bVar;
    }
}
