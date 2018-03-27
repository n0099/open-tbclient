package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl bTt;
    private a cWL;
    private c gtL;
    private b gtM;
    private int gtJ = PushConstants.WORK_RECEIVER_EVENTCORE_ERROR;
    private int gtK = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.bTt != null && j.this.bTt.isPlaying()) {
                int currentPosition = j.this.bTt.getCurrentPosition();
                int duration = j.this.bTt.getDuration();
                if (currentPosition < j.this.gtK) {
                    if (j.this.cWL != null) {
                        j.this.cWL.alf();
                    }
                } else if (currentPosition == j.this.gtK && j.this.gtL != null) {
                    j.this.gtL.WZ();
                }
                if (j.this.gtM != null) {
                    j.this.gtM.cw(duration, currentPosition);
                }
                j.this.gtK = currentPosition;
                j.this.bln();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void alf();
    }

    /* loaded from: classes.dex */
    public interface b {
        void cw(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void WZ();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bTt = mediaPlayerControl;
    }

    public void start() {
        this.gtK = 0;
        bln();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bln() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.gtJ);
    }

    public void a(a aVar) {
        this.cWL = aVar;
    }

    public void a(c cVar) {
        this.gtL = cVar;
    }
}
