package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl bdw;
    private a coJ;
    private c fOu;
    private b fOv;
    private int fOs = PushConstants.WORK_RECEIVER_EVENTCORE_ERROR;
    private int fOt = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.bdw != null && j.this.bdw.isPlaying()) {
                int currentPosition = j.this.bdw.getCurrentPosition();
                int duration = j.this.bdw.getDuration();
                if (currentPosition < j.this.fOt) {
                    if (j.this.coJ != null) {
                        j.this.coJ.afo();
                    }
                } else if (currentPosition == j.this.fOt && j.this.fOu != null) {
                    j.this.fOu.Pz();
                }
                if (j.this.fOv != null) {
                    j.this.fOv.bv(duration, currentPosition);
                }
                j.this.fOt = currentPosition;
                j.this.bgt();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void afo();
    }

    /* loaded from: classes.dex */
    public interface b {
        void bv(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void Pz();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bdw = mediaPlayerControl;
    }

    public void start() {
        this.fOt = 0;
        bgt();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgt() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.fOs);
    }

    public void a(a aVar) {
        this.coJ = aVar;
    }

    public void a(c cVar) {
        this.fOu = cVar;
    }
}
