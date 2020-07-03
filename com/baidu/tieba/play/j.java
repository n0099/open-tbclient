package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl eZk;
    private a gRe;
    private c kSR;
    private b kSS;
    private int kSP = 1000;
    private int kSQ = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.eZk != null && j.this.eZk.isPlaying()) {
                int currentPosition = j.this.eZk.getCurrentPosition();
                int duration = j.this.eZk.getDuration();
                if (currentPosition < j.this.kSQ) {
                    if (j.this.gRe != null) {
                        j.this.gRe.qx();
                    }
                } else if (currentPosition == j.this.kSQ && j.this.kSR != null) {
                    j.this.kSR.btG();
                }
                if (j.this.kSS != null) {
                    j.this.kSS.bM(duration, currentPosition);
                }
                j.this.kSQ = currentPosition;
                j.this.cVi();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void qx();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bM(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void btG();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.eZk = mediaPlayerControl;
    }

    public void start() {
        this.kSQ = 0;
        cVi();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVi() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.kSP);
    }

    public void a(a aVar) {
        this.gRe = aVar;
    }

    public void a(c cVar) {
        this.kSR = cVar;
    }

    public void a(b bVar) {
        this.kSS = bVar;
    }
}
