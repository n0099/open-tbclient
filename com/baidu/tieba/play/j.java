package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl aZG;
    private a bKO;
    private c fwH;
    private b fwI;
    private int fwF = 3000;
    private int fwG = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.aZG != null && j.this.aZG.isPlaying()) {
                int currentPosition = j.this.aZG.getCurrentPosition();
                int duration = j.this.aZG.getDuration();
                if (currentPosition < j.this.fwG) {
                    if (j.this.bKO != null) {
                        j.this.bKO.XB();
                    }
                } else if (currentPosition == j.this.fwG && j.this.fwH != null) {
                    j.this.fwH.bee();
                }
                if (j.this.fwI != null) {
                    j.this.fwI.bH(duration, currentPosition);
                }
                j.this.fwG = currentPosition;
                j.this.bed();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void XB();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bH(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void bee();
    }

    public void rM(int i) {
        if (i > 0) {
            this.fwF = i;
        }
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.aZG = mediaPlayerControl;
    }

    public void start() {
        this.fwG = 0;
        bed();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bed() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.fwF);
    }

    public void a(a aVar) {
        this.bKO = aVar;
    }

    public void a(c cVar) {
        this.fwH = cVar;
    }

    public void a(b bVar) {
        this.fwI = bVar;
    }
}
