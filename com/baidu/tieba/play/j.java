package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* loaded from: classes.dex */
public class j {
    private MediaController.MediaPlayerControl bdx;
    private a cpT;
    private c fPA;
    private b fPB;
    private int fPy = PushConstants.WORK_RECEIVER_EVENTCORE_ERROR;
    private int fPz = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.play.j.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 1 && j.this.bdx != null && j.this.bdx.isPlaying()) {
                int currentPosition = j.this.bdx.getCurrentPosition();
                int duration = j.this.bdx.getDuration();
                if (currentPosition < j.this.fPz) {
                    if (j.this.cpT != null) {
                        j.this.cpT.afo();
                    }
                } else if (currentPosition == j.this.fPz && j.this.fPA != null) {
                    j.this.fPA.Pw();
                }
                if (j.this.fPB != null) {
                    j.this.fPB.bv(duration, currentPosition);
                }
                j.this.fPz = currentPosition;
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
        void Pw();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.bdx = mediaPlayerControl;
    }

    public void start() {
        this.fPz = 0;
        bgt();
    }

    public void stop() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgt() {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.fPy);
    }

    public void a(a aVar) {
        this.cpT = aVar;
    }

    public void a(c cVar) {
        this.fPA = cVar;
    }
}
