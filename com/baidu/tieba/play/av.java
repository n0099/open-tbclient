package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
import com.baidu.tieba.play.au;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av extends Handler {
    final /* synthetic */ au eTn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public av(au auVar, Looper looper) {
        super(looper);
        this.eTn = auVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        boolean z2;
        MediaController.MediaPlayerControl mediaPlayerControl;
        MediaController.MediaPlayerControl mediaPlayerControl2;
        int Lz;
        au.b bVar;
        int i;
        int i2;
        au.b bVar2;
        switch (message.what) {
            case 1:
                z = this.eTn.aXs;
                if (!z) {
                    z2 = this.eTn.aXt;
                    if (z2) {
                        mediaPlayerControl = this.eTn.aXp;
                        if (mediaPlayerControl != null) {
                            mediaPlayerControl2 = this.eTn.aXp;
                            if (!mediaPlayerControl2.isPlaying()) {
                                return;
                            }
                            Lz = this.eTn.Lz();
                            bVar = this.eTn.due;
                            if (bVar != null) {
                                bVar2 = this.eTn.due;
                                bVar2.fJ(Lz);
                            }
                            Message obtainMessage = obtainMessage(1);
                            i = this.eTn.aXo;
                            i2 = this.eTn.aXo;
                            sendMessageDelayed(obtainMessage, i - (Lz % i2));
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
