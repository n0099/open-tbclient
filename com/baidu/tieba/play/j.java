package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl cNM;
    private a eic;
    private c hWm;
    private b hWn;
    private int hWk = 1000;
    private int hWl = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.cNM != null && j.this.cNM.isPlaying()) {
                int currentPosition = j.this.cNM.getCurrentPosition();
                int duration = j.this.cNM.getDuration();
                if (currentPosition < j.this.hWl) {
                    if (j.this.eic != null) {
                        j.this.eic.qE();
                    }
                } else if (currentPosition == j.this.hWl && j.this.hWm != null) {
                    j.this.hWm.aBn();
                }
                if (j.this.hWn != null) {
                    j.this.hWn.aW(duration, currentPosition);
                }
                j.this.hWl = currentPosition;
                j.this.bTk();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void qE();
    }

    /* loaded from: classes.dex */
    public interface b {
        void aW(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void aBn();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.cNM = mediaPlayerControl;
    }

    public void start() {
        this.hWl = 0;
        bTk();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTk() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.hWk);
    }

    public void a(a aVar) {
        this.eic = aVar;
    }

    public void a(c cVar) {
        this.hWm = cVar;
    }

    public void a(b bVar) {
        this.hWn = bVar;
    }
}
