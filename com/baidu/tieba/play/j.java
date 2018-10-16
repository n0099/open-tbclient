package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl bxJ;
    private a cNb;
    private c gtY;
    private b gtZ;
    private int gtW = 1000;
    private int gtX = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.bxJ != null && j.this.bxJ.isPlaying()) {
                int currentPosition = j.this.bxJ.getCurrentPosition();
                int duration = j.this.bxJ.getDuration();
                if (currentPosition < j.this.gtX) {
                    if (j.this.cNb != null) {
                        j.this.cNb.aoe();
                    }
                } else if (currentPosition == j.this.gtX && j.this.gtY != null) {
                    j.this.gtY.YV();
                }
                if (j.this.gtZ != null) {
                    j.this.gtZ.bC(duration, currentPosition);
                }
                j.this.gtX = currentPosition;
                j.this.bqe();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void aoe();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bC(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void YV();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bxJ = mediaPlayerControl;
    }

    public void start() {
        this.gtX = 0;
        bqe();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqe() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.gtW);
    }

    public void a(a aVar) {
        this.cNb = aVar;
    }

    public void a(c cVar) {
        this.gtY = cVar;
    }

    public void a(b bVar) {
        this.gtZ = bVar;
    }
}
