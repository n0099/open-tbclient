package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class f {
    private MediaController.MediaPlayerControl gjV;
    private a ivR;
    private c mCG;
    private b mCH;
    private int mCE = 1000;
    private int mCF = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && f.this.gjV != null && f.this.gjV.isPlaying()) {
                int currentPosition = f.this.gjV.getCurrentPosition();
                int duration = f.this.gjV.getDuration();
                if (currentPosition < f.this.mCF) {
                    if (f.this.ivR != null) {
                        f.this.ivR.rF();
                    }
                } else if (currentPosition == f.this.mCF && f.this.mCG != null) {
                    f.this.mCG.bUC();
                }
                if (f.this.mCH != null) {
                    f.this.mCH.ch(duration, currentPosition);
                }
                f.this.mCF = currentPosition;
                f.this.dBC();
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
        void bUC();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.gjV = mediaPlayerControl;
    }

    public void start() {
        this.mCF = 0;
        dBC();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBC() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.mCE);
    }

    public void a(a aVar) {
        this.ivR = aVar;
    }

    public void a(c cVar) {
        this.mCG = cVar;
    }

    public void a(b bVar) {
        this.mCH = bVar;
    }
}
