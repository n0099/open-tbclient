package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl eOO;
    private a gEd;
    private c kxO;
    private b kxP;
    private int kxM = 1000;
    private int kxN = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.eOO != null && j.this.eOO.isPlaying()) {
                int currentPosition = j.this.eOO.getCurrentPosition();
                int duration = j.this.eOO.getDuration();
                if (currentPosition < j.this.kxN) {
                    if (j.this.gEd != null) {
                        j.this.gEd.qg();
                    }
                } else if (currentPosition == j.this.kxN && j.this.kxO != null) {
                    j.this.kxO.bqH();
                }
                if (j.this.kxP != null) {
                    j.this.kxP.bI(duration, currentPosition);
                }
                j.this.kxN = currentPosition;
                j.this.cQB();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void qg();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bI(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void bqH();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.eOO = mediaPlayerControl;
    }

    public void start() {
        this.kxN = 0;
        cQB();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQB() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.kxM);
    }

    public void a(a aVar) {
        this.gEd = aVar;
    }

    public void a(c cVar) {
        this.kxO = cVar;
    }

    public void a(b bVar) {
        this.kxP = bVar;
    }
}
