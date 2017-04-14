package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
import com.baidu.tieba.play.au;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av extends Handler {
    final /* synthetic */ au eUX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public av(au auVar, Looper looper) {
        super(looper);
        this.eUX = auVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        boolean z2;
        MediaController.MediaPlayerControl mediaPlayerControl;
        MediaController.MediaPlayerControl mediaPlayerControl2;
        int Ml;
        au.b bVar;
        int i;
        int i2;
        au.b bVar2;
        switch (message.what) {
            case 1:
                z = this.eUX.aWT;
                if (!z) {
                    z2 = this.eUX.aWU;
                    if (z2) {
                        mediaPlayerControl = this.eUX.aWQ;
                        if (mediaPlayerControl != null) {
                            mediaPlayerControl2 = this.eUX.aWQ;
                            if (!mediaPlayerControl2.isPlaying()) {
                                return;
                            }
                            Ml = this.eUX.Ml();
                            bVar = this.eUX.dxz;
                            if (bVar != null) {
                                bVar2 = this.eUX.dxz;
                                bVar2.fM(Ml);
                            }
                            Message obtainMessage = obtainMessage(1);
                            i = this.eUX.aWP;
                            i2 = this.eUX.aWP;
                            sendMessageDelayed(obtainMessage, i - (Ml % i2));
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
