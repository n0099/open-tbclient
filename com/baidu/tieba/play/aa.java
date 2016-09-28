package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
import com.baidu.tieba.play.z;
/* loaded from: classes.dex */
class aa extends Handler {
    final /* synthetic */ z eZj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(z zVar, Looper looper) {
        super(looper);
        this.eZj = zVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        boolean z2;
        MediaController.MediaPlayerControl mediaPlayerControl;
        MediaController.MediaPlayerControl mediaPlayerControl2;
        int apv;
        z.b bVar;
        int i;
        int i2;
        z.b bVar2;
        switch (message.what) {
            case 1:
                z = this.eZj.cSy;
                if (!z) {
                    z2 = this.eZj.cSz;
                    if (z2) {
                        mediaPlayerControl = this.eZj.aPl;
                        if (mediaPlayerControl != null) {
                            mediaPlayerControl2 = this.eZj.aPl;
                            if (!mediaPlayerControl2.isPlaying()) {
                                return;
                            }
                            apv = this.eZj.apv();
                            bVar = this.eZj.aQV;
                            if (bVar != null) {
                                bVar2 = this.eZj.aQV;
                                bVar2.fR(apv);
                            }
                            Message obtainMessage = obtainMessage(1);
                            i = this.eZj.cSv;
                            i2 = this.eZj.cSv;
                            sendMessageDelayed(obtainMessage, i - (apv % i2));
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
