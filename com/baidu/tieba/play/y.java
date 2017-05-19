package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class y {
    private a aSO;
    private MediaController.MediaPlayerControl aXp;
    private b eSs;
    private int eSr = 0;
    private Handler mHandler = new z(this, Looper.getMainLooper());

    /* loaded from: classes.dex */
    public interface a {
        void JW();
    }

    /* loaded from: classes.dex */
    public interface b {
        void aWu();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.aXp = mediaPlayerControl;
    }

    public void start() {
        this.eSr = 0;
        aWt();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWt() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 3000L);
    }

    public void a(a aVar) {
        this.aSO = aVar;
    }

    public void a(b bVar) {
        this.eSs = bVar;
    }
}
