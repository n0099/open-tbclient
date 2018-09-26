package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl btE;
    private a cEH;
    private c gmw;
    private b gmx;
    private int gmu = 1000;
    private int gmv = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.btE != null && j.this.btE.isPlaying()) {
                int currentPosition = j.this.btE.getCurrentPosition();
                int duration = j.this.btE.getDuration();
                if (currentPosition < j.this.gmv) {
                    if (j.this.cEH != null) {
                        j.this.cEH.akC();
                    }
                } else if (currentPosition == j.this.gmv && j.this.gmw != null) {
                    j.this.gmw.Vo();
                }
                if (j.this.gmx != null) {
                    j.this.gmx.bz(duration, currentPosition);
                }
                j.this.gmv = currentPosition;
                j.this.bmQ();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void akC();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bz(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void Vo();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.btE = mediaPlayerControl;
    }

    public void start() {
        this.gmv = 0;
        bmQ();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmQ() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.gmu);
    }

    public void a(a aVar) {
        this.cEH = aVar;
    }

    public void a(c cVar) {
        this.gmw = cVar;
    }

    public void a(b bVar) {
        this.gmx = bVar;
    }
}
