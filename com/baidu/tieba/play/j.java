package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl dVF;
    private a fDX;
    private c jpU;
    private b jpV;
    private int jpS = 1000;
    private int jpT = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.dVF != null && j.this.dVF.isPlaying()) {
                int currentPosition = j.this.dVF.getCurrentPosition();
                int duration = j.this.dVF.getDuration();
                if (currentPosition < j.this.jpT) {
                    if (j.this.fDX != null) {
                        j.this.fDX.lg();
                    }
                } else if (currentPosition == j.this.jpT && j.this.jpU != null) {
                    j.this.jpU.aZE();
                }
                if (j.this.jpV != null) {
                    j.this.jpV.by(duration, currentPosition);
                }
                j.this.jpT = currentPosition;
                j.this.cwb();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void lg();
    }

    /* loaded from: classes.dex */
    public interface b {
        void by(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void aZE();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.dVF = mediaPlayerControl;
    }

    public void start() {
        this.jpT = 0;
        cwb();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwb() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.jpS);
    }

    public void a(a aVar) {
        this.fDX = aVar;
    }

    public void a(c cVar) {
        this.jpU = cVar;
    }

    public void a(b bVar) {
        this.jpV = bVar;
    }
}
