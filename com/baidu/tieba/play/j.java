package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl bdw;
    private a caJ;
    private c fPx;
    private b fPy;
    private int fPv = 3000;
    private int fPw = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.bdw != null && j.this.bdw.isPlaying()) {
                int currentPosition = j.this.bdw.getCurrentPosition();
                int duration = j.this.bdw.getDuration();
                if (currentPosition < j.this.fPw) {
                    if (j.this.caJ != null) {
                        j.this.caJ.abI();
                    }
                } else if (currentPosition == j.this.fPw && j.this.fPx != null) {
                    j.this.fPx.OT();
                }
                if (j.this.fPy != null) {
                    j.this.fPy.bJ(duration, currentPosition);
                }
                j.this.fPw = currentPosition;
                j.this.bjl();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void abI();
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
            this.fPv = i;
        }
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bdw = mediaPlayerControl;
    }

    public void start() {
        this.fPw = 0;
        bjl();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjl() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.fPv);
    }

    public void a(a aVar) {
        this.caJ = aVar;
    }

    public void a(c cVar) {
        this.fPx = cVar;
    }

    public void a(b bVar) {
        this.fPy = bVar;
    }
}
