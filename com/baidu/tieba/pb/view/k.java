package com.baidu.tieba.pb.view;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
class k extends Handler {
    final /* synthetic */ PbVideoProgressView dqN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(PbVideoProgressView pbVideoProgressView, Looper looper) {
        super(looper);
        this.dqN = pbVideoProgressView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        MediaController.MediaPlayerControl mediaPlayerControl;
        MediaController.MediaPlayerControl mediaPlayerControl2;
        int aAE;
        int i;
        int i2;
        switch (message.what) {
            case 1:
                z = this.dqN.dqG;
                if (z) {
                    mediaPlayerControl = this.dqN.dqC;
                    if (mediaPlayerControl != null) {
                        mediaPlayerControl2 = this.dqN.dqC;
                        if (!mediaPlayerControl2.isPlaying()) {
                            return;
                        }
                        aAE = this.dqN.aAE();
                        Message obtainMessage = obtainMessage(1);
                        i = this.dqN.dqB;
                        i2 = this.dqN.dqB;
                        sendMessageDelayed(obtainMessage, i - (aAE % i2));
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }
}
