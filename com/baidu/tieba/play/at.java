package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
import com.baidu.tieba.play.as;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at extends Handler {
    final /* synthetic */ as fgG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public at(as asVar, Looper looper) {
        super(looper);
        this.fgG = asVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        boolean z2;
        MediaController.MediaPlayerControl mediaPlayerControl;
        MediaController.MediaPlayerControl mediaPlayerControl2;
        int ars;
        as.b bVar;
        int i;
        int i2;
        as.b bVar2;
        switch (message.what) {
            case 1:
                z = this.fgG.cYg;
                if (!z) {
                    z2 = this.fgG.cYh;
                    if (z2) {
                        mediaPlayerControl = this.fgG.aRr;
                        if (mediaPlayerControl != null) {
                            mediaPlayerControl2 = this.fgG.aRr;
                            if (!mediaPlayerControl2.isPlaying()) {
                                return;
                            }
                            ars = this.fgG.ars();
                            bVar = this.fgG.aSX;
                            if (bVar != null) {
                                bVar2 = this.fgG.aSX;
                                bVar2.fR(ars);
                            }
                            Message obtainMessage = obtainMessage(1);
                            i = this.fgG.cYd;
                            i2 = this.fgG.cYd;
                            sendMessageDelayed(obtainMessage, i - (ars % i2));
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
