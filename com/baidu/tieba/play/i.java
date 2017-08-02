package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class i {
    private MediaController.MediaPlayerControl aXl;
    private a bFZ;
    private c fyg;
    private b fyh;
    private int fye = 3000;
    private int fyf = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.i.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && i.this.aXl != null && i.this.aXl.isPlaying()) {
                int currentPosition = i.this.aXl.getCurrentPosition();
                int duration = i.this.aXl.getDuration();
                if (currentPosition < i.this.fyf) {
                    if (i.this.bFZ != null) {
                        i.this.bFZ.Wm();
                    }
                } else if (currentPosition == i.this.fyf && i.this.fyg != null) {
                    i.this.fyg.bfx();
                }
                if (i.this.fyh != null) {
                    i.this.fyh.bo(duration, currentPosition);
                }
                i.this.fyf = currentPosition;
                i.this.bfw();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void Wm();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bo(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void bfx();
    }

    public void rC(int i) {
        if (i > 0) {
            this.fye = i;
        }
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.aXl = mediaPlayerControl;
    }

    public void start() {
        this.fyf = 0;
        bfw();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfw() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.fye);
    }

    public void a(a aVar) {
        this.bFZ = aVar;
    }

    public void a(c cVar) {
        this.fyg = cVar;
    }

    public void a(b bVar) {
        this.fyh = bVar;
    }
}
