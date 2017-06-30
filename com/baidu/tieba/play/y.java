package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class y {
    private MediaController.MediaPlayerControl aWk;
    private a bBS;
    private b flt;
    private int fls = 0;
    private Handler mHandler = new z(this, Looper.getMainLooper());

    /* loaded from: classes.dex */
    public interface a {
        void VF();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bbV();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.aWk = mediaPlayerControl;
    }

    public void start() {
        this.fls = 0;
        bbU();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbU() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 3000L);
    }

    public void a(a aVar) {
        this.bBS = aVar;
    }

    public void a(b bVar) {
        this.flt = bVar;
    }
}
