package com.baidu.tieba.pb.view;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
class i extends Handler {
    final /* synthetic */ PbVideoControllerView cVQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(PbVideoControllerView pbVideoControllerView, Looper looper) {
        super(looper);
        this.cVQ = pbVideoControllerView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        boolean z2;
        MediaController.MediaPlayerControl mediaPlayerControl;
        MediaController.MediaPlayerControl mediaPlayerControl2;
        int asU;
        int i;
        int i2;
        switch (message.what) {
            case 1:
                z = this.cVQ.cVK;
                if (!z) {
                    z2 = this.cVQ.cVL;
                    if (z2) {
                        mediaPlayerControl = this.cVQ.cVH;
                        if (mediaPlayerControl != null) {
                            mediaPlayerControl2 = this.cVQ.cVH;
                            if (!mediaPlayerControl2.isPlaying()) {
                                return;
                            }
                            asU = this.cVQ.asU();
                            Message obtainMessage = obtainMessage(1);
                            i = this.cVQ.cVG;
                            i2 = this.cVQ.cVG;
                            sendMessageDelayed(obtainMessage, i - (asU % i2));
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
