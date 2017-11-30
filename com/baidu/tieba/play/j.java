package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl bdr;
    private a caB;
    private b fOA;
    private c fOz;
    private int fOx = 3000;
    private int fOy = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.bdr != null && j.this.bdr.isPlaying()) {
                int currentPosition = j.this.bdr.getCurrentPosition();
                int duration = j.this.bdr.getDuration();
                if (currentPosition < j.this.fOy) {
                    if (j.this.caB != null) {
                        j.this.caB.abG();
                    }
                } else if (currentPosition == j.this.fOy && j.this.fOz != null) {
                    j.this.fOz.OT();
                }
                if (j.this.fOA != null) {
                    j.this.fOA.bI(duration, currentPosition);
                }
                j.this.fOy = currentPosition;
                j.this.bjc();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void abG();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bI(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void OT();
    }

    public void sr(int i) {
        if (i > 0) {
            this.fOx = i;
        }
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bdr = mediaPlayerControl;
    }

    public void start() {
        this.fOy = 0;
        bjc();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjc() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.fOx);
    }

    public void a(a aVar) {
        this.caB = aVar;
    }

    public void a(c cVar) {
        this.fOz = cVar;
    }

    public void a(b bVar) {
        this.fOA = bVar;
    }
}
