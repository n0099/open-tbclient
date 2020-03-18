package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl eaw;
    private a fKB;
    private c jwa;
    private b jwb;
    private int jvY = 1000;
    private int jvZ = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.eaw != null && j.this.eaw.isPlaying()) {
                int currentPosition = j.this.eaw.getCurrentPosition();
                int duration = j.this.eaw.getDuration();
                if (currentPosition < j.this.jvZ) {
                    if (j.this.fKB != null) {
                        j.this.fKB.lw();
                    }
                } else if (currentPosition == j.this.jvZ && j.this.jwa != null) {
                    j.this.jwa.bcw();
                }
                if (j.this.jwb != null) {
                    j.this.jwb.bz(duration, currentPosition);
                }
                j.this.jvZ = currentPosition;
                j.this.cyZ();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void lw();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bz(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void bcw();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.eaw = mediaPlayerControl;
    }

    public void start() {
        this.jvZ = 0;
        cyZ();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyZ() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.jvY);
    }

    public void a(a aVar) {
        this.fKB = aVar;
    }

    public void a(c cVar) {
        this.jwa = cVar;
    }

    public void a(b bVar) {
        this.jwb = bVar;
    }
}
