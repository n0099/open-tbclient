package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl cNP;
    private a ehP;
    private c hVZ;
    private b hWa;
    private int hVX = 1000;
    private int hVY = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.cNP != null && j.this.cNP.isPlaying()) {
                int currentPosition = j.this.cNP.getCurrentPosition();
                int duration = j.this.cNP.getDuration();
                if (currentPosition < j.this.hVY) {
                    if (j.this.ehP != null) {
                        j.this.ehP.qE();
                    }
                } else if (currentPosition == j.this.hVY && j.this.hVZ != null) {
                    j.this.hVZ.aBk();
                }
                if (j.this.hWa != null) {
                    j.this.hWa.aW(duration, currentPosition);
                }
                j.this.hVY = currentPosition;
                j.this.bTg();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void qE();
    }

    /* loaded from: classes.dex */
    public interface b {
        void aW(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void aBk();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.cNP = mediaPlayerControl;
    }

    public void start() {
        this.hVY = 0;
        bTg();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTg() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.hVX);
    }

    public void a(a aVar) {
        this.ehP = aVar;
    }

    public void a(c cVar) {
        this.hVZ = cVar;
    }

    public void a(b bVar) {
        this.hWa = bVar;
    }
}
