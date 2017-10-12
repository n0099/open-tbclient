package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl aZU;
    private a bLa;
    private c fwV;
    private b fwW;
    private int fwT = 3000;
    private int fwU = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.aZU != null && j.this.aZU.isPlaying()) {
                int currentPosition = j.this.aZU.getCurrentPosition();
                int duration = j.this.aZU.getDuration();
                if (currentPosition < j.this.fwU) {
                    if (j.this.bLa != null) {
                        j.this.bLa.XF();
                    }
                } else if (currentPosition == j.this.fwU && j.this.fwV != null) {
                    j.this.fwV.bej();
                }
                if (j.this.fwW != null) {
                    j.this.fwW.bH(duration, currentPosition);
                }
                j.this.fwU = currentPosition;
                j.this.bei();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void XF();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bH(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void bej();
    }

    public void rN(int i) {
        if (i > 0) {
            this.fwT = i;
        }
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.aZU = mediaPlayerControl;
    }

    public void start() {
        this.fwU = 0;
        bei();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bei() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.fwT);
    }

    public void a(a aVar) {
        this.bLa = aVar;
    }

    public void a(c cVar) {
        this.fwV = cVar;
    }

    public void a(b bVar) {
        this.fwW = bVar;
    }
}
