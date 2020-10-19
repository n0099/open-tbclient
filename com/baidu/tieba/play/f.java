package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class f {
    private MediaController.MediaPlayerControl fEA;
    private a hFD;
    private c lQw;
    private b lQx;
    private int lQu = 1000;
    private int lQv = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && f.this.fEA != null && f.this.fEA.isPlaying()) {
                int currentPosition = f.this.fEA.getCurrentPosition();
                int duration = f.this.fEA.getDuration();
                if (currentPosition < f.this.lQv) {
                    if (f.this.hFD != null) {
                        f.this.hFD.sc();
                    }
                } else if (currentPosition == f.this.lQv && f.this.lQw != null) {
                    f.this.lQw.bJS();
                }
                if (f.this.lQx != null) {
                    f.this.lQx.ca(duration, currentPosition);
                }
                f.this.lQv = currentPosition;
                f.this.drk();
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
        void bJS();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.fEA = mediaPlayerControl;
    }

    public void start() {
        this.lQv = 0;
        drk();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drk() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.lQu);
    }

    public void a(a aVar) {
        this.hFD = aVar;
    }

    public void a(c cVar) {
        this.lQw = cVar;
    }

    public void a(b bVar) {
        this.lQx = bVar;
    }
}
