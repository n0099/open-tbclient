package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class f {
    private MediaController.MediaPlayerControl gaC;
    private a iju;
    private c mxq;
    private b mxr;
    private int mxo = 1000;
    private int mxp = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && f.this.gaC != null && f.this.gaC.isPlaying()) {
                int currentPosition = f.this.gaC.getCurrentPosition();
                int duration = f.this.gaC.getDuration();
                if (currentPosition < f.this.mxp) {
                    if (f.this.iju != null) {
                        f.this.iju.se();
                    }
                } else if (currentPosition == f.this.mxp && f.this.mxq != null) {
                    f.this.mxq.bRY();
                }
                if (f.this.mxr != null) {
                    f.this.mxr.ci(duration, currentPosition);
                }
                f.this.mxp = currentPosition;
                f.this.dBL();
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
        void bRY();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.gaC = mediaPlayerControl;
    }

    public void start() {
        this.mxp = 0;
        dBL();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBL() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.mxo);
    }

    public void a(a aVar) {
        this.iju = aVar;
    }

    public void a(c cVar) {
        this.mxq = cVar;
    }

    public void a(b bVar) {
        this.mxr = bVar;
    }
}
