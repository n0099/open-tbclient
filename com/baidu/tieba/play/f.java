package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class f {
    private MediaController.MediaPlayerControl ghQ;
    private a ixc;
    private c mHv;
    private b mHw;
    private int mHt = 1000;
    private int mHu = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && f.this.ghQ != null && f.this.ghQ.isPlaying()) {
                int currentPosition = f.this.ghQ.getCurrentPosition();
                int duration = f.this.ghQ.getDuration();
                if (currentPosition < f.this.mHu) {
                    if (f.this.ixc != null) {
                        f.this.ixc.rD();
                    }
                } else if (currentPosition == f.this.mHu && f.this.mHv != null) {
                    f.this.mHv.bRv();
                }
                if (f.this.mHw != null) {
                    f.this.mHw.cf(duration, currentPosition);
                }
                f.this.mHu = currentPosition;
                f.this.dzZ();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void rD();
    }

    /* loaded from: classes.dex */
    public interface b {
        void cf(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void bRv();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.ghQ = mediaPlayerControl;
    }

    public void start() {
        this.mHu = 0;
        dzZ();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzZ() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.mHt);
    }

    public void a(a aVar) {
        this.ixc = aVar;
    }

    public void a(c cVar) {
        this.mHv = cVar;
    }

    public void a(b bVar) {
        this.mHw = bVar;
    }
}
