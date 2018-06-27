package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl bng;
    private a cwq;
    private c geN;
    private b geO;
    private int geL = 3000;
    private int geM = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.bng != null && j.this.bng.isPlaying()) {
                int currentPosition = j.this.bng.getCurrentPosition();
                int duration = j.this.bng.getDuration();
                if (currentPosition < j.this.geM) {
                    if (j.this.cwq != null) {
                        j.this.cwq.aip();
                    }
                } else if (currentPosition == j.this.geM && j.this.geN != null) {
                    j.this.geN.Tq();
                }
                if (j.this.geO != null) {
                    j.this.geO.bw(duration, currentPosition);
                }
                j.this.geM = currentPosition;
                j.this.blV();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void aip();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bw(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void Tq();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bng = mediaPlayerControl;
    }

    public void start() {
        this.geM = 0;
        blV();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blV() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.geL);
    }

    public void a(a aVar) {
        this.cwq = aVar;
    }

    public void a(c cVar) {
        this.geN = cVar;
    }
}
