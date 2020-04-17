package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl eAj;
    private a gph;
    private c kfU;
    private b kfV;
    private int kfS = 1000;
    private int kfT = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.eAj != null && j.this.eAj.isPlaying()) {
                int currentPosition = j.this.eAj.getCurrentPosition();
                int duration = j.this.eAj.getDuration();
                if (currentPosition < j.this.kfT) {
                    if (j.this.gph != null) {
                        j.this.gph.qa();
                    }
                } else if (currentPosition == j.this.kfT && j.this.kfU != null) {
                    j.this.kfU.bln();
                }
                if (j.this.kfV != null) {
                    j.this.kfV.bE(duration, currentPosition);
                }
                j.this.kfT = currentPosition;
                j.this.cJE();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void qa();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bE(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void bln();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.eAj = mediaPlayerControl;
    }

    public void start() {
        this.kfT = 0;
        cJE();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJE() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.kfS);
    }

    public void a(a aVar) {
        this.gph = aVar;
    }

    public void a(c cVar) {
        this.kfU = cVar;
    }

    public void a(b bVar) {
        this.kfV = bVar;
    }
}
