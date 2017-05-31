package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class y {
    private MediaController.MediaPlayerControl aUR;
    private a bAZ;
    private b fbd;
    private int fbc = 0;
    private Handler mHandler = new z(this, Looper.getMainLooper());

    /* loaded from: classes.dex */
    public interface a {
        void Uo();
    }

    /* loaded from: classes.dex */
    public interface b {
        void aXK();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.aUR = mediaPlayerControl;
    }

    public void start() {
        this.fbc = 0;
        aXJ();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXJ() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 3000L);
    }

    public void a(a aVar) {
        this.bAZ = aVar;
    }

    public void a(b bVar) {
        this.fbd = bVar;
    }
}
