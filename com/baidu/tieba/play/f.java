package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class f {
    private MediaController.MediaPlayerControl fsp;
    private a hqJ;
    private c lBh;
    private b lBi;
    private int lBf = 1000;
    private int lBg = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && f.this.fsp != null && f.this.fsp.isPlaying()) {
                int currentPosition = f.this.fsp.getCurrentPosition();
                int duration = f.this.fsp.getDuration();
                if (currentPosition < f.this.lBg) {
                    if (f.this.hqJ != null) {
                        f.this.hqJ.sc();
                    }
                } else if (currentPosition == f.this.lBg && f.this.lBh != null) {
                    f.this.lBh.bHg();
                }
                if (f.this.lBi != null) {
                    f.this.lBi.ca(duration, currentPosition);
                }
                f.this.lBg = currentPosition;
                f.this.dnz();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void sc();
    }

    /* loaded from: classes.dex */
    public interface b {
        void ca(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void bHg();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.fsp = mediaPlayerControl;
    }

    public void start() {
        this.lBg = 0;
        dnz();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnz() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.lBf);
    }

    public void a(a aVar) {
        this.hqJ = aVar;
    }

    public void a(c cVar) {
        this.lBh = cVar;
    }

    public void a(b bVar) {
        this.lBi = bVar;
    }
}
