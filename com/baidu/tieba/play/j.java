package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl dVO;
    private a fHh;
    private c jtA;
    private b jtB;
    private int jty = 1000;
    private int jtz = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.dVO != null && j.this.dVO.isPlaying()) {
                int currentPosition = j.this.dVO.getCurrentPosition();
                int duration = j.this.dVO.getDuration();
                if (currentPosition < j.this.jtz) {
                    if (j.this.fHh != null) {
                        j.this.fHh.lh();
                    }
                } else if (currentPosition == j.this.jtz && j.this.jtA != null) {
                    j.this.jtA.aZZ();
                }
                if (j.this.jtB != null) {
                    j.this.jtB.bx(duration, currentPosition);
                }
                j.this.jtz = currentPosition;
                j.this.cxk();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void lh();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bx(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void aZZ();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.dVO = mediaPlayerControl;
    }

    public void start() {
        this.jtz = 0;
        cxk();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxk() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.jty);
    }

    public void a(a aVar) {
        this.fHh = aVar;
    }

    public void a(c cVar) {
        this.jtA = cVar;
    }

    public void a(b bVar) {
        this.jtB = bVar;
    }
}
