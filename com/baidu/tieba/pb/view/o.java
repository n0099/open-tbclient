package com.baidu.tieba.pb.view;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
/* loaded from: classes.dex */
class o extends Handler {
    final /* synthetic */ PbVideoControllerView dsP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PbVideoControllerView pbVideoControllerView, Looper looper) {
        super(looper);
        this.dsP = pbVideoControllerView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        boolean z2;
        MediaController.MediaPlayerControl mediaPlayerControl;
        MediaController.MediaPlayerControl mediaPlayerControl2;
        int aAS;
        int i;
        int i2;
        switch (message.what) {
            case 1:
                z = this.dsP.dsJ;
                if (!z) {
                    z2 = this.dsP.dsK;
                    if (z2) {
                        mediaPlayerControl = this.dsP.dsG;
                        if (mediaPlayerControl != null) {
                            mediaPlayerControl2 = this.dsP.dsG;
                            if (!mediaPlayerControl2.isPlaying()) {
                                return;
                            }
                            aAS = this.dsP.aAS();
                            Message obtainMessage = obtainMessage(1);
                            i = this.dsP.dsF;
                            i2 = this.dsP.dsF;
                            sendMessageDelayed(obtainMessage, i - (aAS % i2));
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
