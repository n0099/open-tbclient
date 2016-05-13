package com.baidu.tieba.pb.view;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
class q extends Handler {
    final /* synthetic */ PbVideoProgressView dsR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(PbVideoProgressView pbVideoProgressView, Looper looper) {
        super(looper);
        this.dsR = pbVideoProgressView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        MediaController.MediaPlayerControl mediaPlayerControl;
        MediaController.MediaPlayerControl mediaPlayerControl2;
        int aAS;
        int i;
        int i2;
        switch (message.what) {
            case 1:
                z = this.dsR.dsK;
                if (z) {
                    mediaPlayerControl = this.dsR.dsG;
                    if (mediaPlayerControl != null) {
                        mediaPlayerControl2 = this.dsR.dsG;
                        if (!mediaPlayerControl2.isPlaying()) {
                            return;
                        }
                        aAS = this.dsR.aAS();
                        Message obtainMessage = obtainMessage(1);
                        i = this.dsR.dsF;
                        i2 = this.dsR.dsF;
                        sendMessageDelayed(obtainMessage, i - (aAS % i2));
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
