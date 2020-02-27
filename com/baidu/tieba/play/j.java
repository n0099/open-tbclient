package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl dZS;
    private a fJE;
    private c jun;
    private b juo;
    private int jul = 1000;
    private int jum = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.dZS != null && j.this.dZS.isPlaying()) {
                int currentPosition = j.this.dZS.getCurrentPosition();
                int duration = j.this.dZS.getDuration();
                if (currentPosition < j.this.jum) {
                    if (j.this.fJE != null) {
                        j.this.fJE.lw();
                    }
                } else if (currentPosition == j.this.jum && j.this.jun != null) {
                    j.this.jun.bcp();
                }
                if (j.this.juo != null) {
                    j.this.juo.by(duration, currentPosition);
                }
                j.this.jum = currentPosition;
                j.this.cyD();
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
        void bcp();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.dZS = mediaPlayerControl;
    }

    public void start() {
        this.jum = 0;
        cyD();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyD() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.jul);
    }

    public void a(a aVar) {
        this.fJE = aVar;
    }

    public void a(c cVar) {
        this.jun = cVar;
    }

    public void a(b bVar) {
        this.juo = bVar;
    }
}
