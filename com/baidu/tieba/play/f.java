package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class f {
    private MediaController.MediaPlayerControl fSL;
    private a hXX;
    private c miT;
    private b miU;
    private int miR = 1000;
    private int miS = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && f.this.fSL != null && f.this.fSL.isPlaying()) {
                int currentPosition = f.this.fSL.getCurrentPosition();
                int duration = f.this.fSL.getDuration();
                if (currentPosition < f.this.miS) {
                    if (f.this.hXX != null) {
                        f.this.hXX.sc();
                    }
                } else if (currentPosition == f.this.miS && f.this.miT != null) {
                    f.this.miT.bOU();
                }
                if (f.this.miU != null) {
                    f.this.miU.ce(duration, currentPosition);
                }
                f.this.miS = currentPosition;
                f.this.dwT();
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
        void bOU();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.fSL = mediaPlayerControl;
    }

    public void start() {
        this.miS = 0;
        dwT();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwT() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.miR);
    }

    public void a(a aVar) {
        this.hXX = aVar;
    }

    public void a(c cVar) {
        this.miT = cVar;
    }

    public void a(b bVar) {
        this.miU = bVar;
    }
}
