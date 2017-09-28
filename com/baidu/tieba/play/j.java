package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl aZU;
    private a bLa;
    private c fwW;
    private b fwX;
    private int fwU = 3000;
    private int fwV = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.aZU != null && j.this.aZU.isPlaying()) {
                int currentPosition = j.this.aZU.getCurrentPosition();
                int duration = j.this.aZU.getDuration();
                if (currentPosition < j.this.fwV) {
                    if (j.this.bLa != null) {
                        j.this.bLa.XF();
                    }
                } else if (currentPosition == j.this.fwV && j.this.fwW != null) {
                    j.this.fwW.bek();
                }
                if (j.this.fwX != null) {
                    j.this.fwX.bH(duration, currentPosition);
                }
                j.this.fwV = currentPosition;
                j.this.bej();
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
        void bek();
    }

    public void rN(int i) {
        if (i > 0) {
            this.fwU = i;
        }
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.aZU = mediaPlayerControl;
    }

    public void start() {
        this.fwV = 0;
        bej();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bej() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.fwU);
    }

    public void a(a aVar) {
        this.bLa = aVar;
    }

    public void a(c cVar) {
        this.fwW = cVar;
    }

    public void a(b bVar) {
        this.fwX = bVar;
    }
}
