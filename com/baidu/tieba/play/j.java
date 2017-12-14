package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl bds;
    private a caF;
    private c fPs;
    private b fPt;
    private int fPq = 3000;
    private int fPr = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.bds != null && j.this.bds.isPlaying()) {
                int currentPosition = j.this.bds.getCurrentPosition();
                int duration = j.this.bds.getDuration();
                if (currentPosition < j.this.fPr) {
                    if (j.this.caF != null) {
                        j.this.caF.abJ();
                    }
                } else if (currentPosition == j.this.fPr && j.this.fPs != null) {
                    j.this.fPs.OT();
                }
                if (j.this.fPt != null) {
                    j.this.fPt.bJ(duration, currentPosition);
                }
                j.this.fPr = currentPosition;
                j.this.bjl();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void abJ();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bJ(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void OT();
    }

    public void sy(int i) {
        if (i > 0) {
            this.fPq = i;
        }
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bds = mediaPlayerControl;
    }

    public void start() {
        this.fPr = 0;
        bjl();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjl() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.fPq);
    }

    public void a(a aVar) {
        this.caF = aVar;
    }

    public void a(c cVar) {
        this.fPs = cVar;
    }

    public void a(b bVar) {
        this.fPt = bVar;
    }
}
