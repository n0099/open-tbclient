package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
import com.baidu.tieba.play.av;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw extends Handler {
    final /* synthetic */ av fmq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aw(av avVar, Looper looper) {
        super(looper);
        this.fmq = avVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        boolean z2;
        MediaController.MediaPlayerControl mediaPlayerControl;
        MediaController.MediaPlayerControl mediaPlayerControl2;
        int KS;
        av.b bVar;
        int i;
        int i2;
        av.b bVar2;
        switch (message.what) {
            case 1:
                z = this.fmq.aWn;
                if (!z) {
                    z2 = this.fmq.aWo;
                    if (z2) {
                        mediaPlayerControl = this.fmq.aWk;
                        if (mediaPlayerControl != null) {
                            mediaPlayerControl2 = this.fmq.aWk;
                            if (!mediaPlayerControl2.isPlaying()) {
                                return;
                            }
                            KS = this.fmq.KS();
                            bVar = this.fmq.dIi;
                            if (bVar != null) {
                                bVar2 = this.fmq.dIi;
                                bVar2.fL(KS);
                            }
                            Message obtainMessage = obtainMessage(1);
                            i = this.fmq.aWj;
                            i2 = this.fmq.aWj;
                            sendMessageDelayed(obtainMessage, i - (KS % i2));
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
