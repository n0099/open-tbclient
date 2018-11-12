package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl byu;
    private a cOh;
    private b gvA;
    private c gvz;
    private int gvx = 1000;
    private int gvy = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.byu != null && j.this.byu.isPlaying()) {
                int currentPosition = j.this.byu.getCurrentPosition();
                int duration = j.this.byu.getDuration();
                if (currentPosition < j.this.gvy) {
                    if (j.this.cOh != null) {
                        j.this.cOh.anG();
                    }
                } else if (currentPosition == j.this.gvy && j.this.gvz != null) {
                    j.this.gvz.Zg();
                }
                if (j.this.gvA != null) {
                    j.this.gvA.bE(duration, currentPosition);
                }
                j.this.gvy = currentPosition;
                j.this.bpA();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void anG();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bE(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void Zg();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.byu = mediaPlayerControl;
    }

    public void start() {
        this.gvy = 0;
        bpA();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpA() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.gvx);
    }

    public void a(a aVar) {
        this.cOh = aVar;
    }

    public void a(c cVar) {
        this.gvz = cVar;
    }

    public void a(b bVar) {
        this.gvA = bVar;
    }
}
