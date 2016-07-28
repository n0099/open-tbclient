package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
import com.baidu.tieba.play.j;
/* loaded from: classes.dex */
class l extends Handler {
    final /* synthetic */ j ePx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(j jVar, Looper looper) {
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
        j.b bVar2;
        switch (message.what) {
            case 2:
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
                            bVar = this.ePx.aKZ;
                            if (bVar != null) {
                                bVar2 = this.ePx.aKZ;
                                bVar2.ft(akt);
                            }
                            sendMessage(obtainMessage(2));
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
