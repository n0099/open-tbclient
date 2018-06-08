package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl blH;
    private a cyw;
    private c gaM;
    private b gaN;
    private int gaK = 3000;
    private int gaL = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.blH != null && j.this.blH.isPlaying()) {
                int currentPosition = j.this.blH.getCurrentPosition();
                int duration = j.this.blH.getDuration();
                if (currentPosition < j.this.gaL) {
                    if (j.this.cyw != null) {
                        j.this.cyw.aiX();
                    }
                } else if (currentPosition == j.this.gaL && j.this.gaM != null) {
                    j.this.gaM.SU();
                }
                if (j.this.gaN != null) {
                    j.this.gaN.bx(duration, currentPosition);
                }
                j.this.gaL = currentPosition;
                j.this.blr();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void aiX();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bx(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void SU();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.blH = mediaPlayerControl;
    }

    public void start() {
        this.gaL = 0;
        blr();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blr() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.gaK);
    }

    public void a(a aVar) {
        this.cyw = aVar;
    }

    public void a(c cVar) {
        this.gaM = cVar;
    }
}
