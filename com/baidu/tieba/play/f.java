package com.baidu.tieba.play;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class f {
    private MediaController.MediaPlayerControl aOb;
    private a aZD;
    private int eWk = 0;
    private Handler mHandler = new g(this, Looper.getMainLooper());

    /* loaded from: classes.dex */
    public interface a {
        void NB();
    }

    public f(Context context) {
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.aOb = mediaPlayerControl;
    }

    public void start() {
        this.eWk = 0;
        aZK();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZK() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 1000L);
    }

    public void a(a aVar) {
        this.aZD = aVar;
    }
}
