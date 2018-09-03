package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl bnP;
    private a cyQ;
    private c gfe;
    private b gff;
    private int gfc = 1000;
    private int gfd = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.bnP != null && j.this.bnP.isPlaying()) {
                int currentPosition = j.this.bnP.getCurrentPosition();
                int duration = j.this.bnP.getDuration();
                if (currentPosition < j.this.gfd) {
                    if (j.this.cyQ != null) {
                        j.this.cyQ.aiR();
                    }
                } else if (currentPosition == j.this.gfd && j.this.gfe != null) {
                    j.this.gfe.TB();
                }
                if (j.this.gff != null) {
                    j.this.gff.bx(duration, currentPosition);
                }
                j.this.gfd = currentPosition;
                j.this.bkk();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void aiR();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bx(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void TB();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bnP = mediaPlayerControl;
    }

    public void start() {
        this.gfd = 0;
        bkk();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkk() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.gfc);
    }

    public void a(a aVar) {
        this.cyQ = aVar;
    }

    public void a(c cVar) {
        this.gfe = cVar;
    }

    public void a(b bVar) {
        this.gff = bVar;
    }
}
