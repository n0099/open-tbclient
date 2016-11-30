package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class w {
    private a aNV;
    private MediaController.MediaPlayerControl aRr;
    private b ffC;
    private int ffB = 0;
    private Handler mHandler = new x(this, Looper.getMainLooper());

    /* loaded from: classes.dex */
    public interface a {
        void JW();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bcI();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.aRr = mediaPlayerControl;
    }

    public void start() {
        this.ffB = 0;
        bcH();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcH() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 3000L);
    }

    public void a(a aVar) {
        this.aNV = aVar;
    }

    public void a(b bVar) {
        this.ffC = bVar;
    }
}
