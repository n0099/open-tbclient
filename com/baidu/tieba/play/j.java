package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl cNO;
    private a ehO;
    private c hVY;
    private b hVZ;
    private int hVW = 1000;
    private int hVX = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.cNO != null && j.this.cNO.isPlaying()) {
                int currentPosition = j.this.cNO.getCurrentPosition();
                int duration = j.this.cNO.getDuration();
                if (currentPosition < j.this.hVX) {
                    if (j.this.ehO != null) {
                        j.this.ehO.qE();
                    }
                } else if (currentPosition == j.this.hVX && j.this.hVY != null) {
                    j.this.hVY.aBk();
                }
                if (j.this.hVZ != null) {
                    j.this.hVZ.aW(duration, currentPosition);
                }
                j.this.hVX = currentPosition;
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
        this.cNO = mediaPlayerControl;
    }

    public void start() {
        this.hVX = 0;
        bTg();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTg() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.hVW);
    }

    public void a(a aVar) {
        this.ehO = aVar;
    }

    public void a(c cVar) {
        this.hVY = cVar;
    }

    public void a(b bVar) {
        this.hVZ = bVar;
    }
}
