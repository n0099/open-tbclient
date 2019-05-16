package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl cWa;
    private a exC;
    private c ioL;
    private b ioM;
    private int ioJ = 1000;
    private int ioK = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.cWa != null && j.this.cWa.isPlaying()) {
                int currentPosition = j.this.cWa.getCurrentPosition();
                int duration = j.this.cWa.getDuration();
                if (currentPosition < j.this.ioK) {
                    if (j.this.exC != null) {
                        j.this.exC.pz();
                    }
                } else if (currentPosition == j.this.ioK && j.this.ioL != null) {
                    j.this.ioL.aHB();
                }
                if (j.this.ioM != null) {
                    j.this.ioM.bc(duration, currentPosition);
                }
                j.this.ioK = currentPosition;
                j.this.cbh();
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
        void aHB();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.cWa = mediaPlayerControl;
    }

    public void start() {
        this.ioK = 0;
        cbh();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbh() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.ioJ);
    }

    public void a(a aVar) {
        this.exC = aVar;
    }

    public void a(c cVar) {
        this.ioL = cVar;
    }

    public void a(b bVar) {
        this.ioM = bVar;
    }
}
