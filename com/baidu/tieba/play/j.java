package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl eOZ;
    private a gEo;
    private c kyU;
    private b kyV;
    private int kyS = 1000;
    private int kyT = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.eOZ != null && j.this.eOZ.isPlaying()) {
                int currentPosition = j.this.eOZ.getCurrentPosition();
                int duration = j.this.eOZ.getDuration();
                if (currentPosition < j.this.kyT) {
                    if (j.this.gEo != null) {
                        j.this.gEo.qg();
                    }
                } else if (currentPosition == j.this.kyT && j.this.kyU != null) {
                    j.this.kyU.bqJ();
                }
                if (j.this.kyV != null) {
                    j.this.kyV.bI(duration, currentPosition);
                }
                j.this.kyT = currentPosition;
                j.this.cQR();
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
        void bqJ();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.eOZ = mediaPlayerControl;
    }

    public void start() {
        this.kyT = 0;
        cQR();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQR() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.kyS);
    }

    public void a(a aVar) {
        this.gEo = aVar;
    }

    public void a(c cVar) {
        this.kyU = cVar;
    }

    public void a(b bVar) {
        this.kyV = bVar;
    }
}
