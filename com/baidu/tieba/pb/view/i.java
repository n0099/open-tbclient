package com.baidu.tieba.pb.view;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
class i extends Handler {
    final /* synthetic */ PbVideoControllerView dqL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(PbVideoControllerView pbVideoControllerView, Looper looper) {
        super(looper);
        this.dqL = pbVideoControllerView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        boolean z2;
        MediaController.MediaPlayerControl mediaPlayerControl;
        MediaController.MediaPlayerControl mediaPlayerControl2;
        int aAE;
        int i;
        int i2;
        switch (message.what) {
            case 1:
                z = this.dqL.dqF;
                if (!z) {
                    z2 = this.dqL.dqG;
                    if (z2) {
                        mediaPlayerControl = this.dqL.dqC;
                        if (mediaPlayerControl != null) {
                            mediaPlayerControl2 = this.dqL.dqC;
                            if (!mediaPlayerControl2.isPlaying()) {
                                return;
                            }
                            aAE = this.dqL.aAE();
                            Message obtainMessage = obtainMessage(1);
                            i = this.dqL.dqB;
                            i2 = this.dqL.dqB;
                            sendMessageDelayed(obtainMessage, i - (aAE % i2));
                            return;
                        }
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
