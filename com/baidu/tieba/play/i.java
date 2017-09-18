package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class i {
    private MediaController.MediaPlayerControl aYh;
    private a bLE;
    private c fAI;
    private b fAJ;
    private int fAG = 3000;
    private int fAH = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.i.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && i.this.aYh != null && i.this.aYh.isPlaying()) {
                int currentPosition = i.this.aYh.getCurrentPosition();
                int duration = i.this.aYh.getDuration();
                if (currentPosition < i.this.fAH) {
                    if (i.this.bLE != null) {
                        i.this.bLE.XZ();
                    }
                } else if (currentPosition == i.this.fAH && i.this.fAI != null) {
                    i.this.fAI.bfH();
                }
                if (i.this.fAJ != null) {
                    i.this.fAJ.bA(duration, currentPosition);
                }
                i.this.fAH = currentPosition;
                i.this.bfG();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void XZ();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bA(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void bfH();
    }

    public void rN(int i) {
        if (i > 0) {
            this.fAG = i;
        }
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.aYh = mediaPlayerControl;
    }

    public void start() {
        this.fAH = 0;
        bfG();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfG() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.fAG);
    }

    public void a(a aVar) {
        this.bLE = aVar;
    }

    public void a(c cVar) {
        this.fAI = cVar;
    }

    public void a(b bVar) {
        this.fAJ = bVar;
    }
}
