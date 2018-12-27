package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl bBU;
    private a cXE;
    private c gFg;
    private b gFh;
    private int gFe = 1000;
    private int gFf = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.bBU != null && j.this.bBU.isPlaying()) {
                int currentPosition = j.this.bBU.getCurrentPosition();
                int duration = j.this.bBU.getDuration();
                if (currentPosition < j.this.gFf) {
                    if (j.this.cXE != null) {
                        j.this.cXE.aqi();
                    }
                } else if (currentPosition == j.this.gFf && j.this.gFg != null) {
                    j.this.gFg.aao();
                }
                if (j.this.gFh != null) {
                    j.this.gFh.bD(duration, currentPosition);
                }
                j.this.gFf = currentPosition;
                j.this.bse();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void aqi();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bD(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void aao();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bBU = mediaPlayerControl;
    }

    public void start() {
        this.gFf = 0;
        bse();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bse() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.gFe);
    }

    public void a(a aVar) {
        this.cXE = aVar;
    }

    public void a(c cVar) {
        this.gFg = cVar;
    }

    public void a(b bVar) {
        this.gFh = bVar;
    }
}
