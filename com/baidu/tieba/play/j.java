package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl cXy;
    private a eCB;
    private c ivf;
    private b ivg;
    private int ivd = 1000;
    private int ive = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.cXy != null && j.this.cXy.isPlaying()) {
                int currentPosition = j.this.cXy.getCurrentPosition();
                int duration = j.this.cXy.getDuration();
                if (currentPosition < j.this.ive) {
                    if (j.this.eCB != null) {
                        j.this.eCB.pU();
                    }
                } else if (currentPosition == j.this.ive && j.this.ivf != null) {
                    j.this.ivf.aJb();
                }
                if (j.this.ivg != null) {
                    j.this.ivg.bh(duration, currentPosition);
                }
                j.this.ive = currentPosition;
                j.this.cea();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void pU();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bh(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void aJb();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.cXy = mediaPlayerControl;
    }

    public void start() {
        this.ive = 0;
        cea();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cea() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.ivd);
    }

    public void a(a aVar) {
        this.eCB = aVar;
    }

    public void a(c cVar) {
        this.ivf = cVar;
    }

    public void a(b bVar) {
        this.ivg = bVar;
    }
}
