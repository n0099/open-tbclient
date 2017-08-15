package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class i {
    private MediaController.MediaPlayerControl aYx;
    private a bHS;
    private c fBl;
    private b fBm;
    private int fBj = 3000;
    private int fBk = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.i.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && i.this.aYx != null && i.this.aYx.isPlaying()) {
                int currentPosition = i.this.aYx.getCurrentPosition();
                int duration = i.this.aYx.getDuration();
                if (currentPosition < i.this.fBk) {
                    if (i.this.bHS != null) {
                        i.this.bHS.WN();
                    }
                } else if (currentPosition == i.this.fBk && i.this.fBl != null) {
                    i.this.fBl.bgn();
                }
                if (i.this.fBm != null) {
                    i.this.fBm.bx(duration, currentPosition);
                }
                i.this.fBk = currentPosition;
                i.this.bgm();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void WN();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bx(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void bgn();
    }

    public void rL(int i) {
        if (i > 0) {
            this.fBj = i;
        }
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.aYx = mediaPlayerControl;
    }

    public void start() {
        this.fBk = 0;
        bgm();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgm() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.fBj);
    }

    public void a(a aVar) {
        this.bHS = aVar;
    }

    public void a(c cVar) {
        this.fBl = cVar;
    }

    public void a(b bVar) {
        this.fBm = bVar;
    }
}
