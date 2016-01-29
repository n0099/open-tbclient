package com.baidu.tieba.pb.view;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
class k extends Handler {
    final /* synthetic */ PbVideoProgressView cVS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(PbVideoProgressView pbVideoProgressView, Looper looper) {
        super(looper);
        this.cVS = pbVideoProgressView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        MediaController.MediaPlayerControl mediaPlayerControl;
        MediaController.MediaPlayerControl mediaPlayerControl2;
        int asU;
        int i;
        int i2;
        switch (message.what) {
            case 1:
                z = this.cVS.cVL;
                if (z) {
                    mediaPlayerControl = this.cVS.cVH;
                    if (mediaPlayerControl != null) {
                        mediaPlayerControl2 = this.cVS.cVH;
                        if (!mediaPlayerControl2.isPlaying()) {
                            return;
                        }
                        asU = this.cVS.asU();
                        Message obtainMessage = obtainMessage(1);
                        i = this.cVS.cVG;
                        i2 = this.cVS.cVG;
                        sendMessageDelayed(obtainMessage, i - (asU % i2));
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
