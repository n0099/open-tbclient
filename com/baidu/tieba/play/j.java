package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl bxJ;
    private a cNb;
    private c gtZ;
    private b gua;
    private int gtX = 1000;
    private int gtY = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.bxJ != null && j.this.bxJ.isPlaying()) {
                int currentPosition = j.this.bxJ.getCurrentPosition();
                int duration = j.this.bxJ.getDuration();
                if (currentPosition < j.this.gtY) {
                    if (j.this.cNb != null) {
                        j.this.cNb.aof();
                    }
                } else if (currentPosition == j.this.gtY && j.this.gtZ != null) {
                    j.this.gtZ.YW();
                }
                if (j.this.gua != null) {
                    j.this.gua.bC(duration, currentPosition);
                }
                j.this.gtY = currentPosition;
                j.this.bqe();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void aof();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bC(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void YW();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bxJ = mediaPlayerControl;
    }

    public void start() {
        this.gtY = 0;
        bqe();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqe() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.gtX);
    }

    public void a(a aVar) {
        this.cNb = aVar;
    }

    public void a(c cVar) {
        this.gtZ = cVar;
    }

    public void a(b bVar) {
        this.gua = bVar;
    }
}
