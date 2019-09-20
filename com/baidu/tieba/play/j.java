package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl cZl;
    private a eEr;
    private c iyj;
    private b iyk;
    private int iyh = 1000;
    private int iyi = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.cZl != null && j.this.cZl.isPlaying()) {
                int currentPosition = j.this.cZl.getCurrentPosition();
                int duration = j.this.cZl.getDuration();
                if (currentPosition < j.this.iyi) {
                    if (j.this.eEr != null) {
                        j.this.eEr.pV();
                    }
                } else if (currentPosition == j.this.iyi && j.this.iyj != null) {
                    j.this.iyj.aJH();
                }
                if (j.this.iyk != null) {
                    j.this.iyk.bh(duration, currentPosition);
                }
                j.this.iyi = currentPosition;
                j.this.cfh();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void pV();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bh(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void aJH();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.cZl = mediaPlayerControl;
    }

    public void start() {
        this.iyi = 0;
        cfh();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfh() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.iyh);
    }

    public void a(a aVar) {
        this.eEr = aVar;
    }

    public void a(c cVar) {
        this.iyj = cVar;
    }

    public void a(b bVar) {
        this.iyk = bVar;
    }
}
