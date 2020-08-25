package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes2.dex */
public class f {
    private MediaController.MediaPlayerControl fpe;
    private a hjC;
    private c lse;
    private b lsf;
    private int lsc = 1000;
    private int lsd = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && f.this.fpe != null && f.this.fpe.isPlaying()) {
                int currentPosition = f.this.fpe.getCurrentPosition();
                int duration = f.this.fpe.getDuration();
                if (currentPosition < f.this.lsd) {
                    if (f.this.hjC != null) {
                        f.this.hjC.rX();
                    }
                } else if (currentPosition == f.this.lsd && f.this.lse != null) {
                    f.this.lse.bFP();
                }
                if (f.this.lsf != null) {
                    f.this.lsf.bX(duration, currentPosition);
                }
                f.this.lsd = currentPosition;
                f.this.djQ();
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void rX();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void bX(int i, int i2);
    }

    /* loaded from: classes2.dex */
    public interface c {
        void bFP();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.fpe = mediaPlayerControl;
    }

    public void start() {
        this.lsd = 0;
        djQ();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djQ() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.lsc);
    }

    public void a(a aVar) {
        this.hjC = aVar;
    }

    public void a(c cVar) {
        this.lse = cVar;
    }

    public void a(b bVar) {
        this.lsf = bVar;
    }
}
