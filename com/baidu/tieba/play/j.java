package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl dhS;
    private a eMh;
    private c ivU;
    private b ivV;
    private int ivS = 1000;
    private int ivT = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.dhS != null && j.this.dhS.isPlaying()) {
                int currentPosition = j.this.dhS.getCurrentPosition();
                int duration = j.this.dhS.getDuration();
                if (currentPosition < j.this.ivT) {
                    if (j.this.eMh != null) {
                        j.this.eMh.kP();
                    }
                } else if (currentPosition == j.this.ivT && j.this.ivU != null) {
                    j.this.ivU.aJg();
                }
                if (j.this.ivV != null) {
                    j.this.ivV.bh(duration, currentPosition);
                }
                j.this.ivT = currentPosition;
                j.this.cch();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void kP();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bh(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void aJg();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.dhS = mediaPlayerControl;
    }

    public void start() {
        this.ivT = 0;
        cch();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cch() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.ivS);
    }

    public void a(a aVar) {
        this.eMh = aVar;
    }

    public void a(c cVar) {
        this.ivU = cVar;
    }

    public void a(b bVar) {
        this.ivV = bVar;
    }
}
