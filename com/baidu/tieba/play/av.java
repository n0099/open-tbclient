package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
import com.baidu.tieba.play.au;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av extends Handler {
    final /* synthetic */ au eWY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public av(au auVar, Looper looper) {
        super(looper);
        this.eWY = auVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        boolean z2;
        MediaController.MediaPlayerControl mediaPlayerControl;
        MediaController.MediaPlayerControl mediaPlayerControl2;
        int LK;
        au.b bVar;
        int i;
        int i2;
        au.b bVar2;
        switch (message.what) {
            case 1:
                z = this.eWY.aWG;
                if (!z) {
                    z2 = this.eWY.aWH;
                    if (z2) {
                        mediaPlayerControl = this.eWY.aWD;
                        if (mediaPlayerControl != null) {
                            mediaPlayerControl2 = this.eWY.aWD;
                            if (!mediaPlayerControl2.isPlaying()) {
                                return;
                            }
                            LK = this.eWY.LK();
                            bVar = this.eWY.dAR;
                            if (bVar != null) {
                                bVar2 = this.eWY.dAR;
                                bVar2.fJ(LK);
                            }
                            Message obtainMessage = obtainMessage(1);
                            i = this.eWY.aWC;
                            i2 = this.eWY.aWC;
                            sendMessageDelayed(obtainMessage, i - (LK % i2));
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
