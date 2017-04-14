package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.widget.MediaController;
/* loaded from: classes.dex */
public class y {
    private a aSr;
    private MediaController.MediaPlayerControl aWQ;
    private b eUc;
    private int eUb = 0;
    private Handler mHandler = new z(this, Looper.getMainLooper());

    /* loaded from: classes.dex */
    public interface a {
        void KI();
    }

    /* loaded from: classes.dex */
    public interface b {
        void aXU();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.aWQ = mediaPlayerControl;
    }

    public void start() {
        this.eUb = 0;
        aXT();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXT() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 3000L);
    }

    public void a(a aVar) {
        this.aSr = aVar;
    }

    public void a(b bVar) {
        this.eUc = bVar;
    }
}
