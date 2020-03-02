package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl dZT;
    private a fJG;
    private c jup;
    private b juq;
    private int jun = 1000;
    private int juo = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.dZT != null && j.this.dZT.isPlaying()) {
                int currentPosition = j.this.dZT.getCurrentPosition();
                int duration = j.this.dZT.getDuration();
                if (currentPosition < j.this.juo) {
                    if (j.this.fJG != null) {
                        j.this.fJG.lw();
                    }
                } else if (currentPosition == j.this.juo && j.this.jup != null) {
                    j.this.jup.bcr();
                }
                if (j.this.juq != null) {
                    j.this.juq.by(duration, currentPosition);
                }
                j.this.juo = currentPosition;
                j.this.cyF();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void lw();
    }

    /* loaded from: classes.dex */
    public interface b {
        void by(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void bcr();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.dZT = mediaPlayerControl;
    }

    public void start() {
        this.juo = 0;
        cyF();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyF() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.jun);
    }

    public void a(a aVar) {
        this.fJG = aVar;
    }

    public void a(c cVar) {
        this.jup = cVar;
    }

    public void a(b bVar) {
        this.juq = bVar;
    }
}
