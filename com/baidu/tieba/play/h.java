package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class h {
    private a aMa;
    private MediaController.MediaPlayerControl aPl;
    private b eYp;
    private int eYo = 0;
    private Handler mHandler = new i(this, Looper.getMainLooper());

    /* loaded from: classes.dex */
    public interface a {
        void Ju();
    }

    /* loaded from: classes.dex */
    public interface b {
        void baj();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.aPl = mediaPlayerControl;
    }

    public void start() {
        this.eYo = 0;
        bai();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bai() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 2000L);
    }

    public void a(a aVar) {
        this.aMa = aVar;
    }

    public void a(b bVar) {
        this.eYp = bVar;
    }
}
