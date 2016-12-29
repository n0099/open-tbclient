package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
import com.baidu.tieba.play.as;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at extends Handler {
    final /* synthetic */ as eJY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public at(as asVar, Looper looper) {
        super(looper);
        this.eJY = asVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        boolean z2;
        MediaController.MediaPlayerControl mediaPlayerControl;
        MediaController.MediaPlayerControl mediaPlayerControl2;
        int alU;
        as.b bVar;
        int i;
        int i2;
        as.b bVar2;
        switch (message.what) {
            case 1:
                z = this.eJY.cDp;
                if (!z) {
                    z2 = this.eJY.cDq;
                    if (z2) {
                        mediaPlayerControl = this.eJY.aQI;
                        if (mediaPlayerControl != null) {
                            mediaPlayerControl2 = this.eJY.aQI;
                            if (!mediaPlayerControl2.isPlaying()) {
                                return;
                            }
                            alU = this.eJY.alU();
                            bVar = this.eJY.aSo;
                            if (bVar != null) {
                                bVar2 = this.eJY.aSo;
                                bVar2.fQ(alU);
                            }
                            Message obtainMessage = obtainMessage(1);
                            i = this.eJY.cDm;
                            i2 = this.eJY.cDm;
                            sendMessageDelayed(obtainMessage, i - (alU % i2));
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
