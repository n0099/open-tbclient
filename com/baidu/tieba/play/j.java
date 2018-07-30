package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl bnM;
    private a cyT;
    private c gff;
    private b gfg;
    private int gfd = 1000;
    private int gfe = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.bnM != null && j.this.bnM.isPlaying()) {
                int currentPosition = j.this.bnM.getCurrentPosition();
                int duration = j.this.bnM.getDuration();
                if (currentPosition < j.this.gfe) {
                    if (j.this.cyT != null) {
                        j.this.cyT.aiO();
                    }
                } else if (currentPosition == j.this.gfe && j.this.gff != null) {
                    j.this.gff.Ty();
                }
                if (j.this.gfg != null) {
                    j.this.gfg.bx(duration, currentPosition);
                }
                j.this.gfe = currentPosition;
                j.this.bkn();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void aiO();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bx(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void Ty();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bnM = mediaPlayerControl;
    }

    public void start() {
        this.gfe = 0;
        bkn();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkn() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.gfd);
    }

    public void a(a aVar) {
        this.cyT = aVar;
    }

    public void a(c cVar) {
        this.gff = cVar;
    }

    public void a(b bVar) {
        this.gfg = bVar;
    }
}
