package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class y {
    private a aSb;
    private MediaController.MediaPlayerControl aWD;
    private b eWd;
    private int eWc = 0;
    private Handler mHandler = new z(this, Looper.getMainLooper());

    /* loaded from: classes.dex */
    public interface a {
        void Ki();
    }

    /* loaded from: classes.dex */
    public interface b {
        void aXL();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.aWD = mediaPlayerControl;
    }

    public void start() {
        this.eWc = 0;
        aXK();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXK() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 3000L);
    }

    public void a(a aVar) {
        this.aSb = aVar;
    }

    public void a(b bVar) {
        this.eWd = bVar;
    }
}
