package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class f {
    private MediaController.MediaPlayerControl gjV;
    private a ivR;
    private c mCH;
    private b mCI;
    private int mCF = 1000;
    private int mCG = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && f.this.gjV != null && f.this.gjV.isPlaying()) {
                int currentPosition = f.this.gjV.getCurrentPosition();
                int duration = f.this.gjV.getDuration();
                if (currentPosition < f.this.mCG) {
                    if (f.this.ivR != null) {
                        f.this.ivR.rF();
                    }
                } else if (currentPosition == f.this.mCG && f.this.mCH != null) {
                    f.this.mCH.bUB();
                }
                if (f.this.mCI != null) {
                    f.this.mCI.ch(duration, currentPosition);
                }
                f.this.mCG = currentPosition;
                f.this.dBB();
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
        void bUB();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.gjV = mediaPlayerControl;
    }

    public void start() {
        this.mCG = 0;
        dBB();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBB() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.mCF);
    }

    public void a(a aVar) {
        this.ivR = aVar;
    }

    public void a(c cVar) {
        this.mCH = cVar;
    }

    public void a(b bVar) {
        this.mCI = bVar;
    }
}
