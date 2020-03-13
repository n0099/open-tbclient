package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl eag;
    private a fJT;
    private c juB;
    private b juC;
    private int juz = 1000;
    private int juA = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.eag != null && j.this.eag.isPlaying()) {
                int currentPosition = j.this.eag.getCurrentPosition();
                int duration = j.this.eag.getDuration();
                if (currentPosition < j.this.juA) {
                    if (j.this.fJT != null) {
                        j.this.fJT.lw();
                    }
                } else if (currentPosition == j.this.juA && j.this.juB != null) {
                    j.this.juB.bcs();
                }
                if (j.this.juC != null) {
                    j.this.juC.by(duration, currentPosition);
                }
                j.this.juA = currentPosition;
                j.this.cyG();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void lw();
    }

    /* loaded from: classes.dex */
    public interface b {
        void by(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void bcs();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.eag = mediaPlayerControl;
    }

    public void start() {
        this.juA = 0;
        cyG();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyG() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.juz);
    }

    public void a(a aVar) {
        this.fJT = aVar;
    }

    public void a(c cVar) {
        this.juB = cVar;
    }

    public void a(b bVar) {
        this.juC = bVar;
    }
}
