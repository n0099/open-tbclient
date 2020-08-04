package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class f {
    private MediaController.MediaPlayerControl fdM;
    private a gWJ;
    private c lbO;
    private b lbP;
    private int lbM = 1000;
    private int lbN = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && f.this.fdM != null && f.this.fdM.isPlaying()) {
                int currentPosition = f.this.fdM.getCurrentPosition();
                int duration = f.this.fdM.getDuration();
                if (currentPosition < f.this.lbN) {
                    if (f.this.gWJ != null) {
                        f.this.gWJ.qy();
                    }
                } else if (currentPosition == f.this.lbN && f.this.lbO != null) {
                    f.this.lbO.bwQ();
                }
                if (f.this.lbP != null) {
                    f.this.lbP.bP(duration, currentPosition);
                }
                f.this.lbN = currentPosition;
                f.this.cYN();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void qy();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bP(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void bwQ();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.fdM = mediaPlayerControl;
    }

    public void start() {
        this.lbN = 0;
        cYN();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYN() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.lbM);
    }

    public void a(a aVar) {
        this.gWJ = aVar;
    }

    public void a(c cVar) {
        this.lbO = cVar;
    }

    public void a(b bVar) {
        this.lbP = bVar;
    }
}
