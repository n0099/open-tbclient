package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
import com.baidu.tieba.play.au;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av extends Handler {
    final /* synthetic */ au eTs;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public av(au auVar, Looper looper) {
        super(looper);
        this.eTs = auVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        boolean z2;
        MediaController.MediaPlayerControl mediaPlayerControl;
        MediaController.MediaPlayerControl mediaPlayerControl2;
        int and;
        au.b bVar;
        int i;
        int i2;
        au.b bVar2;
        switch (message.what) {
            case 1:
                z = this.eTs.cKy;
                if (!z) {
                    z2 = this.eTs.cKz;
                    if (z2) {
                        mediaPlayerControl = this.eTs.cKv;
                        if (mediaPlayerControl != null) {
                            mediaPlayerControl2 = this.eTs.cKv;
                            if (!mediaPlayerControl2.isPlaying()) {
                                return;
                            }
                            and = this.eTs.and();
                            bVar = this.eTs.dyt;
                            if (bVar != null) {
                                bVar2 = this.eTs.dyt;
                                bVar2.mQ(and);
                            }
                            Message obtainMessage = obtainMessage(1);
                            i = this.eTs.cKu;
                            i2 = this.eTs.cKu;
                            sendMessageDelayed(obtainMessage, i - (and % i2));
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
