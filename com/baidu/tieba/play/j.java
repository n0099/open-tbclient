package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl bRi;
    private a cPp;
    private c gCy;
    private b gCz;
    private int gCw = PushConstants.WORK_RECEIVER_EVENTCORE_ERROR;
    private int gCx = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.bRi != null && j.this.bRi.isPlaying()) {
                int currentPosition = j.this.bRi.getCurrentPosition();
                int duration = j.this.bRi.getDuration();
                if (currentPosition < j.this.gCx) {
                    if (j.this.cPp != null) {
                        j.this.cPp.ajo();
                    }
                } else if (currentPosition == j.this.gCx && j.this.gCy != null) {
                    j.this.gCy.Ws();
                }
                if (j.this.gCz != null) {
                    j.this.gCz.cH(duration, currentPosition);
                }
                j.this.gCx = currentPosition;
                j.this.bqG();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void ajo();
    }

    /* loaded from: classes.dex */
    public interface b {
        void cH(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void Ws();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bRi = mediaPlayerControl;
    }

    public void start() {
        this.gCx = 0;
        bqG();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqG() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.gCw);
    }

    public void a(a aVar) {
        this.cPp = aVar;
    }

    public void a(c cVar) {
        this.gCy = cVar;
    }
}
