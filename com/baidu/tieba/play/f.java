package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class f {
    private MediaController.MediaPlayerControl gaE;
    private a ijw;
    private c mxs;
    private b mxt;
    private int mxq = 1000;
    private int mxr = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && f.this.gaE != null && f.this.gaE.isPlaying()) {
                int currentPosition = f.this.gaE.getCurrentPosition();
                int duration = f.this.gaE.getDuration();
                if (currentPosition < f.this.mxr) {
                    if (f.this.ijw != null) {
                        f.this.ijw.se();
                    }
                } else if (currentPosition == f.this.mxr && f.this.mxs != null) {
                    f.this.mxs.bRZ();
                }
                if (f.this.mxt != null) {
                    f.this.mxt.ci(duration, currentPosition);
                }
                f.this.mxr = currentPosition;
                f.this.dBM();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void se();
    }

    /* loaded from: classes.dex */
    public interface b {
        void ci(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void bRZ();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.gaE = mediaPlayerControl;
    }

    public void start() {
        this.mxr = 0;
        dBM();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBM() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.mxq);
    }

    public void a(a aVar) {
        this.ijw = aVar;
    }

    public void a(c cVar) {
        this.mxs = cVar;
    }

    public void a(b bVar) {
        this.mxt = bVar;
    }
}
