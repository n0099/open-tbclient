package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl bTq;
    private a cWI;
    private c gtv;
    private b gtw;
    private int gtt = PushConstants.WORK_RECEIVER_EVENTCORE_ERROR;
    private int gtu = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.bTq != null && j.this.bTq.isPlaying()) {
                int currentPosition = j.this.bTq.getCurrentPosition();
                int duration = j.this.bTq.getDuration();
                if (currentPosition < j.this.gtu) {
                    if (j.this.cWI != null) {
                        j.this.cWI.ale();
                    }
                } else if (currentPosition == j.this.gtu && j.this.gtv != null) {
                    j.this.gtv.WY();
                }
                if (j.this.gtw != null) {
                    j.this.gtw.cw(duration, currentPosition);
                }
                j.this.gtu = currentPosition;
                j.this.blm();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void ale();
    }

    /* loaded from: classes.dex */
    public interface b {
        void cw(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void WY();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bTq = mediaPlayerControl;
    }

    public void start() {
        this.gtu = 0;
        blm();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blm() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.gtt);
    }

    public void a(a aVar) {
        this.cWI = aVar;
    }

    public void a(c cVar) {
        this.gtv = cVar;
    }
}
