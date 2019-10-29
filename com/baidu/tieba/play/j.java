package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl diK;
    private a eMY;
    private c iwL;
    private b iwM;
    private int iwJ = 1000;
    private int iwK = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.diK != null && j.this.diK.isPlaying()) {
                int currentPosition = j.this.diK.getCurrentPosition();
                int duration = j.this.diK.getDuration();
                if (currentPosition < j.this.iwK) {
                    if (j.this.eMY != null) {
                        j.this.eMY.kP();
                    }
                } else if (currentPosition == j.this.iwK && j.this.iwL != null) {
                    j.this.iwL.aJi();
                }
                if (j.this.iwM != null) {
                    j.this.iwM.bj(duration, currentPosition);
                }
                j.this.iwK = currentPosition;
                j.this.ccj();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void kP();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bj(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void aJi();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.diK = mediaPlayerControl;
    }

    public void start() {
        this.iwK = 0;
        ccj();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccj() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.iwJ);
    }

    public void a(a aVar) {
        this.eMY = aVar;
    }

    public void a(c cVar) {
        this.iwL = cVar;
    }

    public void a(b bVar) {
        this.iwM = bVar;
    }
}
