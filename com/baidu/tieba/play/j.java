package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl eAo;
    private a gpn;
    private c kfY;
    private b kfZ;
    private int kfW = 1000;
    private int kfX = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.eAo != null && j.this.eAo.isPlaying()) {
                int currentPosition = j.this.eAo.getCurrentPosition();
                int duration = j.this.eAo.getDuration();
                if (currentPosition < j.this.kfX) {
                    if (j.this.gpn != null) {
                        j.this.gpn.qa();
                    }
                } else if (currentPosition == j.this.kfX && j.this.kfY != null) {
                    j.this.kfY.bll();
                }
                if (j.this.kfZ != null) {
                    j.this.kfZ.bE(duration, currentPosition);
                }
                j.this.kfX = currentPosition;
                j.this.cJC();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void qa();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bE(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void bll();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.eAo = mediaPlayerControl;
    }

    public void start() {
        this.kfX = 0;
        cJC();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJC() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.kfW);
    }

    public void a(a aVar) {
        this.gpn = aVar;
    }

    public void a(c cVar) {
        this.kfY = cVar;
    }

    public void a(b bVar) {
        this.kfZ = bVar;
    }
}
