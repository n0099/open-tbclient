package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class j {
    private a bSI;
    private MediaController.MediaPlayerControl bag;
    private c fFO;
    private b fFP;
    private int fFM = 3000;
    private int fFN = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.bag != null && j.this.bag.isPlaying()) {
                int currentPosition = j.this.bag.getCurrentPosition();
                int duration = j.this.bag.getDuration();
                if (currentPosition < j.this.fFN) {
                    if (j.this.bSI != null) {
                        j.this.bSI.ZX();
                    }
                } else if (currentPosition == j.this.fFN && j.this.fFO != null) {
                    j.this.fFO.bhv();
                }
                if (j.this.fFP != null) {
                    j.this.fFP.bI(duration, currentPosition);
                }
                j.this.fFN = currentPosition;
                j.this.bhu();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void ZX();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bI(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void bhv();
    }

    public void sd(int i) {
        if (i > 0) {
            this.fFM = i;
        }
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bag = mediaPlayerControl;
    }

    public void start() {
        this.fFN = 0;
        bhu();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhu() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.fFM);
    }

    public void a(a aVar) {
        this.bSI = aVar;
    }

    public void a(c cVar) {
        this.fFO = cVar;
    }

    public void a(b bVar) {
        this.fFP = bVar;
    }
}
