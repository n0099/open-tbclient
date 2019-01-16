package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl bCH;
    private a cYp;
    private c gGk;
    private b gGl;
    private int gGi = 1000;
    private int gGj = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.bCH != null && j.this.bCH.isPlaying()) {
                int currentPosition = j.this.bCH.getCurrentPosition();
                int duration = j.this.bCH.getDuration();
                if (currentPosition < j.this.gGj) {
                    if (j.this.cYp != null) {
                        j.this.cYp.aqF();
                    }
                } else if (currentPosition == j.this.gGj && j.this.gGk != null) {
                    j.this.gGk.aaL();
                }
                if (j.this.gGl != null) {
                    j.this.gGl.bD(duration, currentPosition);
                }
                j.this.gGj = currentPosition;
                j.this.bsN();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void aqF();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bD(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void aaL();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bCH = mediaPlayerControl;
    }

    public void start() {
        this.gGj = 0;
        bsN();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsN() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.gGi);
    }

    public void a(a aVar) {
        this.cYp = aVar;
    }

    public void a(c cVar) {
        this.gGk = cVar;
    }

    public void a(b bVar) {
        this.gGl = bVar;
    }
}
