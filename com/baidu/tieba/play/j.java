package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl cNP;
    private a eig;
    private c hWs;
    private b hWt;
    private int hWq = 1000;
    private int hWr = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.cNP != null && j.this.cNP.isPlaying()) {
                int currentPosition = j.this.cNP.getCurrentPosition();
                int duration = j.this.cNP.getDuration();
                if (currentPosition < j.this.hWr) {
                    if (j.this.eig != null) {
                        j.this.eig.qE();
                    }
                } else if (currentPosition == j.this.hWr && j.this.hWs != null) {
                    j.this.hWs.aBo();
                }
                if (j.this.hWt != null) {
                    j.this.hWt.aW(duration, currentPosition);
                }
                j.this.hWr = currentPosition;
                j.this.bTi();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void qE();
    }

    /* loaded from: classes.dex */
    public interface b {
        void aW(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void aBo();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.cNP = mediaPlayerControl;
    }

    public void start() {
        this.hWr = 0;
        bTi();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTi() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.hWq);
    }

    public void a(a aVar) {
        this.eig = aVar;
    }

    public void a(c cVar) {
        this.hWs = cVar;
    }

    public void a(b bVar) {
        this.hWt = bVar;
    }
}
