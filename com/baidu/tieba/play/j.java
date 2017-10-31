package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl aZX;
    private a bSv;
    private c fFr;
    private b fFs;
    private int fFp = 3000;
    private int fFq = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.aZX != null && j.this.aZX.isPlaying()) {
                int currentPosition = j.this.aZX.getCurrentPosition();
                int duration = j.this.aZX.getDuration();
                if (currentPosition < j.this.fFq) {
                    if (j.this.bSv != null) {
                        j.this.bSv.ZL();
                    }
                } else if (currentPosition == j.this.fFq && j.this.fFr != null) {
                    j.this.fFr.bhn();
                }
                if (j.this.fFs != null) {
                    j.this.fFs.bJ(duration, currentPosition);
                }
                j.this.fFq = currentPosition;
                j.this.bhm();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void ZL();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bJ(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void bhn();
    }

    public void sc(int i) {
        if (i > 0) {
            this.fFp = i;
        }
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.aZX = mediaPlayerControl;
    }

    public void start() {
        this.fFq = 0;
        bhm();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhm() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.fFp);
    }

    public void a(a aVar) {
        this.bSv = aVar;
    }

    public void a(c cVar) {
        this.fFr = cVar;
    }

    public void a(b bVar) {
        this.fFs = bVar;
    }
}
