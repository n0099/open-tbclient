package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl cWc;
    private a exD;
    private c ioP;
    private b ioQ;
    private int ioN = 1000;
    private int ioO = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.cWc != null && j.this.cWc.isPlaying()) {
                int currentPosition = j.this.cWc.getCurrentPosition();
                int duration = j.this.cWc.getDuration();
                if (currentPosition < j.this.ioO) {
                    if (j.this.exD != null) {
                        j.this.exD.pz();
                    }
                } else if (currentPosition == j.this.ioO && j.this.ioP != null) {
                    j.this.ioP.aHE();
                }
                if (j.this.ioQ != null) {
                    j.this.ioQ.bc(duration, currentPosition);
                }
                j.this.ioO = currentPosition;
                j.this.cbl();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void pz();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bc(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void aHE();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.cWc = mediaPlayerControl;
    }

    public void start() {
        this.ioO = 0;
        cbl();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbl() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.ioN);
    }

    public void a(a aVar) {
        this.exD = aVar;
    }

    public void a(c cVar) {
        this.ioP = cVar;
    }

    public void a(b bVar) {
        this.ioQ = bVar;
    }
}
