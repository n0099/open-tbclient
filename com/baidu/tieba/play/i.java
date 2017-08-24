package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class i {
    private MediaController.MediaPlayerControl aYy;
    private a bHT;
    private c fBn;
    private b fBo;
    private int fBl = 3000;
    private int fBm = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.i.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && i.this.aYy != null && i.this.aYy.isPlaying()) {
                int currentPosition = i.this.aYy.getCurrentPosition();
                int duration = i.this.aYy.getDuration();
                if (currentPosition < i.this.fBm) {
                    if (i.this.bHT != null) {
                        i.this.bHT.WK();
                    }
                } else if (currentPosition == i.this.fBm && i.this.fBn != null) {
                    i.this.fBn.bgi();
                }
                if (i.this.fBo != null) {
                    i.this.fBo.bx(duration, currentPosition);
                }
                i.this.fBm = currentPosition;
                i.this.bgh();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void WK();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bx(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void bgi();
    }

    public void rL(int i) {
        if (i > 0) {
            this.fBl = i;
        }
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.aYy = mediaPlayerControl;
    }

    public void start() {
        this.fBm = 0;
        bgh();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgh() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.fBl);
    }

    public void a(a aVar) {
        this.bHT = aVar;
    }

    public void a(c cVar) {
        this.fBn = cVar;
    }

    public void a(b bVar) {
        this.fBo = bVar;
    }
}
