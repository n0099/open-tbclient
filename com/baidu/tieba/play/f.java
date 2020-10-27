package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class f {
    private MediaController.MediaPlayerControl fMV;
    private a hSa;
    private c mcU;
    private b mcV;
    private int mcS = 1000;
    private int mcT = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && f.this.fMV != null && f.this.fMV.isPlaying()) {
                int currentPosition = f.this.fMV.getCurrentPosition();
                int duration = f.this.fMV.getDuration();
                if (currentPosition < f.this.mcT) {
                    if (f.this.hSa != null) {
                        f.this.hSa.sc();
                    }
                } else if (currentPosition == f.this.mcT && f.this.mcU != null) {
                    f.this.mcU.bMu();
                }
                if (f.this.mcV != null) {
                    f.this.mcV.cc(duration, currentPosition);
                }
                f.this.mcT = currentPosition;
                f.this.dur();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void sc();
    }

    /* loaded from: classes.dex */
    public interface b {
        void cc(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void bMu();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.fMV = mediaPlayerControl;
    }

    public void start() {
        this.mcT = 0;
        dur();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dur() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.mcS);
    }

    public void a(a aVar) {
        this.hSa = aVar;
    }

    public void a(c cVar) {
        this.mcU = cVar;
    }

    public void a(b bVar) {
        this.mcV = bVar;
    }
}
