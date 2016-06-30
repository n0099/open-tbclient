package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
import com.baidu.tieba.play.j;
/* loaded from: classes.dex */
class k extends Handler {
    final /* synthetic */ j eDO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(j jVar, Looper looper) {
        super(looper);
        this.eDO = jVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        boolean z2;
        MediaController.MediaPlayerControl mediaPlayerControl;
        MediaController.MediaPlayerControl mediaPlayerControl2;
        int ajJ;
        j.b bVar;
        int i;
        int i2;
        j.b bVar2;
        switch (message.what) {
            case 1:
                z = this.eDO.cDm;
                if (!z) {
                    z2 = this.eDO.cDn;
                    if (z2) {
                        mediaPlayerControl = this.eDO.cDj;
                        if (mediaPlayerControl != null) {
                            mediaPlayerControl2 = this.eDO.cDj;
                            if (!mediaPlayerControl2.isPlaying()) {
                                return;
                            }
                            ajJ = this.eDO.ajJ();
                            bVar = this.eDO.aKf;
                            if (bVar != null) {
                                bVar2 = this.eDO.aKf;
                                bVar2.fu(ajJ);
                            }
                            Message obtainMessage = obtainMessage(1);
                            i = this.eDO.cDi;
                            i2 = this.eDO.cDi;
                            sendMessageDelayed(obtainMessage, i - (ajJ % i2));
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
