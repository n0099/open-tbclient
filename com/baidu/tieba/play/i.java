package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class i {
    private MediaController.MediaPlayerControl aYk;
    private a bKN;
    private c fzP;
    private b fzQ;
    private int fzN = 3000;
    private int fzO = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.i.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && i.this.aYk != null && i.this.aYk.isPlaying()) {
                int currentPosition = i.this.aYk.getCurrentPosition();
                int duration = i.this.aYk.getDuration();
                if (currentPosition < i.this.fzO) {
                    if (i.this.bKN != null) {
                        i.this.bKN.XO();
                    }
                } else if (currentPosition == i.this.fzO && i.this.fzP != null) {
                    i.this.fzP.bfw();
                }
                if (i.this.fzQ != null) {
                    i.this.fzQ.bw(duration, currentPosition);
                }
                i.this.fzO = currentPosition;
                i.this.bfv();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void XO();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bw(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void bfw();
    }

    public void rL(int i) {
        if (i > 0) {
            this.fzN = i;
        }
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.aYk = mediaPlayerControl;
    }

    public void start() {
        this.fzO = 0;
        bfv();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfv() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.fzN);
    }

    public void a(a aVar) {
        this.bKN = aVar;
    }

    public void a(c cVar) {
        this.fzP = cVar;
    }

    public void a(b bVar) {
        this.fzQ = bVar;
    }
}
