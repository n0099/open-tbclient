package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class i {
    private MediaController.MediaPlayerControl aYw;
    private a bHj;
    private c fzs;
    private b fzt;
    private int fzq = 3000;
    private int fzr = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.i.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && i.this.aYw != null && i.this.aYw.isPlaying()) {
                int currentPosition = i.this.aYw.getCurrentPosition();
                int duration = i.this.aYw.getDuration();
                if (currentPosition < i.this.fzr) {
                    if (i.this.bHj != null) {
                        i.this.bHj.Wr();
                    }
                } else if (currentPosition == i.this.fzr && i.this.fzs != null) {
                    i.this.fzs.bfH();
                }
                if (i.this.fzt != null) {
                    i.this.fzt.bp(duration, currentPosition);
                }
                i.this.fzr = currentPosition;
                i.this.bfG();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void Wr();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bp(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void bfH();
    }

    public void rB(int i) {
        if (i > 0) {
            this.fzq = i;
        }
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.aYw = mediaPlayerControl;
    }

    public void start() {
        this.fzr = 0;
        bfG();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfG() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.fzq);
    }

    public void a(a aVar) {
        this.bHj = aVar;
    }

    public void a(c cVar) {
        this.fzs = cVar;
    }

    public void a(b bVar) {
        this.fzt = bVar;
    }
}
