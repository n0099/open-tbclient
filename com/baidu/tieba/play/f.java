package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class f {
    private MediaController.MediaPlayerControl gfn;
    private a irk;
    private c mya;
    private b myb;
    private int mxY = 1000;
    private int mxZ = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && f.this.gfn != null && f.this.gfn.isPlaying()) {
                int currentPosition = f.this.gfn.getCurrentPosition();
                int duration = f.this.gfn.getDuration();
                if (currentPosition < f.this.mxZ) {
                    if (f.this.irk != null) {
                        f.this.irk.rF();
                    }
                } else if (currentPosition == f.this.mxZ && f.this.mya != null) {
                    f.this.mya.bQK();
                }
                if (f.this.myb != null) {
                    f.this.myb.ch(duration, currentPosition);
                }
                f.this.mxZ = currentPosition;
                f.this.dxK();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void rF();
    }

    /* loaded from: classes.dex */
    public interface b {
        void ch(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void bQK();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.gfn = mediaPlayerControl;
    }

    public void start() {
        this.mxZ = 0;
        dxK();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxK() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.mxY);
    }

    public void a(a aVar) {
        this.irk = aVar;
    }

    public void a(c cVar) {
        this.mya = cVar;
    }

    public void a(b bVar) {
        this.myb = bVar;
    }
}
