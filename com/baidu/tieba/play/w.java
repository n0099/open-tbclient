package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class w {
    private a aNm;
    private MediaController.MediaPlayerControl aQI;
    private b eIU;
    private int eIT = 0;
    private Handler mHandler = new x(this, Looper.getMainLooper());

    /* loaded from: classes.dex */
    public interface a {
        void Jp();
    }

    /* loaded from: classes.dex */
    public interface b {
        void aWp();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.aQI = mediaPlayerControl;
    }

    public void start() {
        this.eIT = 0;
        aWo();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWo() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 3000L);
    }

    public void a(a aVar) {
        this.aNm = aVar;
    }

    public void a(b bVar) {
        this.eIU = bVar;
    }
}
