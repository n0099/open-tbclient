package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class y {
    private a aMo;
    private MediaController.MediaPlayerControl cKv;
    private b eSw;
    private int eSv = 0;
    private Handler mHandler = new z(this, Looper.getMainLooper());

    /* loaded from: classes.dex */
    public interface a {
        void JD();
    }

    /* loaded from: classes.dex */
    public interface b {
        void aYh();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.cKv = mediaPlayerControl;
    }

    public void start() {
        this.eSv = 0;
        aYg();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYg() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 3000L);
    }

    public void a(a aVar) {
        this.aMo = aVar;
    }

    public void a(b bVar) {
        this.eSw = bVar;
    }
}
