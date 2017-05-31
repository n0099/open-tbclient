package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
import com.baidu.tieba.play.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends Handler {
    final /* synthetic */ y fbe;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(y yVar, Looper looper) {
        super(looper);
        this.fbe = yVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        MediaController.MediaPlayerControl mediaPlayerControl;
        MediaController.MediaPlayerControl mediaPlayerControl2;
        MediaController.MediaPlayerControl mediaPlayerControl3;
        int i;
        int i2;
        y.b bVar;
        y.b bVar2;
        y.a aVar;
        y.a aVar2;
        if (message != null && message.what == 1) {
            mediaPlayerControl = this.fbe.aUR;
            if (mediaPlayerControl != null) {
                mediaPlayerControl2 = this.fbe.aUR;
                if (mediaPlayerControl2.isPlaying()) {
                    mediaPlayerControl3 = this.fbe.aUR;
                    int currentPosition = mediaPlayerControl3.getCurrentPosition();
                    i = this.fbe.fbc;
                    if (currentPosition >= i) {
                        i2 = this.fbe.fbc;
                        if (currentPosition == i2) {
                            bVar = this.fbe.fbd;
                            if (bVar != null) {
                                bVar2 = this.fbe.fbd;
                                bVar2.aXK();
                            }
                        }
                    } else {
                        aVar = this.fbe.bAZ;
                        if (aVar != null) {
                            aVar2 = this.fbe.bAZ;
                            aVar2.Uo();
                        }
                    }
                    this.fbe.fbc = currentPosition;
                    this.fbe.aXJ();
                }
            }
        }
    }
}
