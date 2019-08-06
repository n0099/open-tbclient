package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl cXF;
    private a eCI;
    private c iwi;
    private b iwj;
    private int iwg = 1000;
    private int iwh = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.cXF != null && j.this.cXF.isPlaying()) {
                int currentPosition = j.this.cXF.getCurrentPosition();
                int duration = j.this.cXF.getDuration();
                if (currentPosition < j.this.iwh) {
                    if (j.this.eCI != null) {
                        j.this.eCI.pU();
                    }
                } else if (currentPosition == j.this.iwh && j.this.iwi != null) {
                    j.this.iwi.aJd();
                }
                if (j.this.iwj != null) {
                    j.this.iwj.bh(duration, currentPosition);
                }
                j.this.iwh = currentPosition;
                j.this.ces();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void pU();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bh(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void aJd();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.cXF = mediaPlayerControl;
    }

    public void start() {
        this.iwh = 0;
        ces();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ces() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.iwg);
    }

    public void a(a aVar) {
        this.eCI = aVar;
    }

    public void a(c cVar) {
        this.iwi = cVar;
    }

    public void a(b bVar) {
        this.iwj = bVar;
    }
}
