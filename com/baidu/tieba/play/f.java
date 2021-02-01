package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class f {
    private MediaController.MediaPlayerControl ghC;
    private a iwO;
    private c mHg;
    private b mHh;
    private int mHe = 1000;
    private int mHf = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && f.this.ghC != null && f.this.ghC.isPlaying()) {
                int currentPosition = f.this.ghC.getCurrentPosition();
                int duration = f.this.ghC.getDuration();
                if (currentPosition < f.this.mHf) {
                    if (f.this.iwO != null) {
                        f.this.iwO.rD();
                    }
                } else if (currentPosition == f.this.mHf && f.this.mHg != null) {
                    f.this.mHg.bRo();
                }
                if (f.this.mHh != null) {
                    f.this.mHh.ce(duration, currentPosition);
                }
                f.this.mHf = currentPosition;
                f.this.dzS();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void rD();
    }

    /* loaded from: classes.dex */
    public interface b {
        void ce(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void bRo();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.ghC = mediaPlayerControl;
    }

    public void start() {
        this.mHf = 0;
        dzS();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzS() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.mHe);
    }

    public void a(a aVar) {
        this.iwO = aVar;
    }

    public void a(c cVar) {
        this.mHg = cVar;
    }

    public void a(b bVar) {
        this.mHh = bVar;
    }
}
