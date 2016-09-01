package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
import com.baidu.tieba.play.n;
/* loaded from: classes.dex */
class o extends Handler {
    final /* synthetic */ n eWH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(n nVar, Looper looper) {
        super(looper);
        this.eWH = nVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        boolean z2;
        MediaController.MediaPlayerControl mediaPlayerControl;
        MediaController.MediaPlayerControl mediaPlayerControl2;
        int aph;
        n.b bVar;
        int i;
        int i2;
        n.b bVar2;
        switch (message.what) {
            case 1:
                z = this.eWH.cRH;
                if (!z) {
                    z2 = this.eWH.cRI;
                    if (z2) {
                        mediaPlayerControl = this.eWH.aOb;
                        if (mediaPlayerControl != null) {
                            mediaPlayerControl2 = this.eWH.aOb;
                            if (!mediaPlayerControl2.isPlaying()) {
                                return;
                            }
                            aph = this.eWH.aph();
                            bVar = this.eWH.aPJ;
                            if (bVar != null) {
                                bVar2 = this.eWH.aPJ;
                                bVar2.fL(aph);
                            }
                            Message obtainMessage = obtainMessage(1);
                            i = this.eWH.cRE;
                            i2 = this.eWH.cRE;
                            sendMessageDelayed(obtainMessage, i - (aph % i2));
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
