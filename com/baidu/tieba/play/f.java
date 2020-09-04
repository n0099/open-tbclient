package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class f {
    private MediaController.MediaPlayerControl fpi;
    private a hjG;
    private c lsp;
    private b lsq;
    private int lsn = 1000;
    private int lso = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && f.this.fpi != null && f.this.fpi.isPlaying()) {
                int currentPosition = f.this.fpi.getCurrentPosition();
                int duration = f.this.fpi.getDuration();
                if (currentPosition < f.this.lso) {
                    if (f.this.hjG != null) {
                        f.this.hjG.rX();
                    }
                } else if (currentPosition == f.this.lso && f.this.lsp != null) {
                    f.this.lsp.bFQ();
                }
                if (f.this.lsq != null) {
                    f.this.lsq.bX(duration, currentPosition);
                }
                f.this.lso = currentPosition;
                f.this.djT();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void rX();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bX(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void bFQ();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.fpi = mediaPlayerControl;
    }

    public void start() {
        this.lso = 0;
        djT();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djT() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.lsn);
    }

    public void a(a aVar) {
        this.hjG = aVar;
    }

    public void a(c cVar) {
        this.lsp = cVar;
    }

    public void a(b bVar) {
        this.lsq = bVar;
    }
}
