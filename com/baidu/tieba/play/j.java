package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl bCI;
    private a cYq;
    private c gGl;
    private b gGm;
    private int gGj = 1000;
    private int gGk = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.bCI != null && j.this.bCI.isPlaying()) {
                int currentPosition = j.this.bCI.getCurrentPosition();
                int duration = j.this.bCI.getDuration();
                if (currentPosition < j.this.gGk) {
                    if (j.this.cYq != null) {
                        j.this.cYq.aqF();
                    }
                } else if (currentPosition == j.this.gGk && j.this.gGl != null) {
                    j.this.gGl.aaL();
                }
                if (j.this.gGm != null) {
                    j.this.gGm.bD(duration, currentPosition);
                }
                j.this.gGk = currentPosition;
                j.this.bsN();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void aqF();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bD(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void aaL();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bCI = mediaPlayerControl;
    }

    public void start() {
        this.gGk = 0;
        bsN();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsN() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.gGj);
    }

    public void a(a aVar) {
        this.cYq = aVar;
    }

    public void a(c cVar) {
        this.gGl = cVar;
    }

    public void a(b bVar) {
        this.gGm = bVar;
    }
}
