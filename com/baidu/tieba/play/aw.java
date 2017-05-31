package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
import com.baidu.tieba.play.av;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw extends Handler {
    final /* synthetic */ av fca;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aw(av avVar, Looper looper) {
        super(looper);
        this.fca = avVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        boolean z2;
        MediaController.MediaPlayerControl mediaPlayerControl;
        MediaController.MediaPlayerControl mediaPlayerControl2;
        int Ku;
        av.b bVar;
        int i;
        int i2;
        av.b bVar2;
        switch (message.what) {
            case 1:
                z = this.fca.aUU;
                if (!z) {
                    z2 = this.fca.aUV;
                    if (z2) {
                        mediaPlayerControl = this.fca.aUR;
                        if (mediaPlayerControl != null) {
                            mediaPlayerControl2 = this.fca.aUR;
                            if (!mediaPlayerControl2.isPlaying()) {
                                return;
                            }
                            Ku = this.fca.Ku();
                            bVar = this.fca.dzw;
                            if (bVar != null) {
                                bVar2 = this.fca.dzw;
                                bVar2.fJ(Ku);
                            }
                            Message obtainMessage = obtainMessage(1);
                            i = this.fca.aUQ;
                            i2 = this.fca.aUQ;
                            sendMessageDelayed(obtainMessage, i - (Ku % i2));
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
