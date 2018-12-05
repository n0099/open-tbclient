package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl bBR;
    private a cUO;
    private c gCp;
    private b gCq;
    private int gCn = 1000;
    private int gCo = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.bBR != null && j.this.bBR.isPlaying()) {
                int currentPosition = j.this.bBR.getCurrentPosition();
                int duration = j.this.bBR.getDuration();
                if (currentPosition < j.this.gCo) {
                    if (j.this.cUO != null) {
                        j.this.cUO.apt();
                    }
                } else if (currentPosition == j.this.gCo && j.this.gCp != null) {
                    j.this.gCp.aam();
                }
                if (j.this.gCq != null) {
                    j.this.gCq.bC(duration, currentPosition);
                }
                j.this.gCo = currentPosition;
                j.this.brt();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void apt();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bC(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void aam();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bBR = mediaPlayerControl;
    }

    public void start() {
        this.gCo = 0;
        brt();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brt() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.gCn);
    }

    public void a(a aVar) {
        this.cUO = aVar;
    }

    public void a(c cVar) {
        this.gCp = cVar;
    }

    public void a(b bVar) {
        this.gCq = bVar;
    }
}
