package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl cWb;
    private a exD;
    private c ioO;
    private b ioP;
    private int ioM = 1000;
    private int ioN = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.cWb != null && j.this.cWb.isPlaying()) {
                int currentPosition = j.this.cWb.getCurrentPosition();
                int duration = j.this.cWb.getDuration();
                if (currentPosition < j.this.ioN) {
                    if (j.this.exD != null) {
                        j.this.exD.pz();
                    }
                } else if (currentPosition == j.this.ioN && j.this.ioO != null) {
                    j.this.ioO.aHE();
                }
                if (j.this.ioP != null) {
                    j.this.ioP.bc(duration, currentPosition);
                }
                j.this.ioN = currentPosition;
                j.this.cbk();
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
        this.cWb = mediaPlayerControl;
    }

    public void start() {
        this.ioN = 0;
        cbk();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbk() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.ioM);
    }

    public void a(a aVar) {
        this.exD = aVar;
    }

    public void a(c cVar) {
        this.ioO = cVar;
    }

    public void a(b bVar) {
        this.ioP = bVar;
    }
}
