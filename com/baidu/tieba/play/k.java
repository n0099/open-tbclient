package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
import com.baidu.tieba.play.j;
/* loaded from: classes.dex */
class k extends Handler {
    final /* synthetic */ j ePx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(j jVar, Looper looper) {
        super(looper);
        this.ePx = jVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        boolean z2;
        MediaController.MediaPlayerControl mediaPlayerControl;
        MediaController.MediaPlayerControl mediaPlayerControl2;
        int akt;
        j.b bVar;
        int i;
        int i2;
        j.b bVar2;
        switch (message.what) {
            case 1:
                z = this.ePx.cGb;
                if (!z) {
                    z2 = this.ePx.cGc;
                    if (z2) {
                        mediaPlayerControl = this.ePx.cFY;
                        if (mediaPlayerControl != null) {
                            mediaPlayerControl2 = this.ePx.cFY;
                            if (!mediaPlayerControl2.isPlaying()) {
                                return;
                            }
                            akt = this.ePx.akt();
                            bVar = this.ePx.aKY;
                            if (bVar != null) {
                                bVar2 = this.ePx.aKY;
                                bVar2.ft(akt);
                            }
                            Message obtainMessage = obtainMessage(1);
                            i = this.ePx.cFX;
                            i2 = this.ePx.cFX;
                            sendMessageDelayed(obtainMessage, i - (akt % i2));
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
