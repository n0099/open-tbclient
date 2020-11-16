package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class f {
    private MediaController.MediaPlayerControl fSs;
    private a hYx;
    private c mjm;
    private b mjn;
    private int mjk = 1000;
    private int mjl = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && f.this.fSs != null && f.this.fSs.isPlaying()) {
                int currentPosition = f.this.fSs.getCurrentPosition();
                int duration = f.this.fSs.getDuration();
                if (currentPosition < f.this.mjl) {
                    if (f.this.hYx != null) {
                        f.this.hYx.sc();
                    }
                } else if (currentPosition == f.this.mjl && f.this.mjm != null) {
                    f.this.mjm.bOn();
                }
                if (f.this.mjn != null) {
                    f.this.mjn.ce(duration, currentPosition);
                }
                f.this.mjl = currentPosition;
                f.this.dwt();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void sc();
    }

    /* loaded from: classes.dex */
    public interface b {
        void ce(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void bOn();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.fSs = mediaPlayerControl;
    }

    public void start() {
        this.mjl = 0;
        dwt();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwt() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.mjk);
    }

    public void a(a aVar) {
        this.hYx = aVar;
    }

    public void a(c cVar) {
        this.mjm = cVar;
    }

    public void a(b bVar) {
        this.mjn = bVar;
    }
}
