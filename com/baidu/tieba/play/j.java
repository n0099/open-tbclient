package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl bRx;
    private a cUl;
    private c gsa;
    private b gsb;
    private int grY = PushConstants.WORK_RECEIVER_EVENTCORE_ERROR;
    private int grZ = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.bRx != null && j.this.bRx.isPlaying()) {
                int currentPosition = j.this.bRx.getCurrentPosition();
                int duration = j.this.bRx.getDuration();
                if (currentPosition < j.this.grZ) {
                    if (j.this.cUl != null) {
                        j.this.cUl.akw();
                    }
                } else if (currentPosition == j.this.grZ && j.this.gsa != null) {
                    j.this.gsa.Wi();
                }
                if (j.this.gsb != null) {
                    j.this.gsb.cA(duration, currentPosition);
                }
                j.this.grZ = currentPosition;
                j.this.bka();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void akw();
    }

    /* loaded from: classes.dex */
    public interface b {
        void cA(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void Wi();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bRx = mediaPlayerControl;
    }

    public void start() {
        this.grZ = 0;
        bka();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bka() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.grY);
    }

    public void a(a aVar) {
        this.cUl = aVar;
    }

    public void a(c cVar) {
        this.gsa = cVar;
    }
}
