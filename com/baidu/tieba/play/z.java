package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
import com.baidu.tieba.play.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends Handler {
    final /* synthetic */ y eWe;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(y yVar, Looper looper) {
        super(looper);
        this.eWe = yVar;
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
            mediaPlayerControl = this.eWe.aWD;
            if (mediaPlayerControl != null) {
                mediaPlayerControl2 = this.eWe.aWD;
                if (mediaPlayerControl2.isPlaying()) {
                    mediaPlayerControl3 = this.eWe.aWD;
                    int currentPosition = mediaPlayerControl3.getCurrentPosition();
                    i = this.eWe.eWc;
                    if (currentPosition >= i) {
                        i2 = this.eWe.eWc;
                        if (currentPosition == i2) {
                            bVar = this.eWe.eWd;
                            if (bVar != null) {
                                bVar2 = this.eWe.eWd;
                                bVar2.aXL();
                            }
                        }
                    } else {
                        aVar = this.eWe.aSb;
                        if (aVar != null) {
                            aVar2 = this.eWe.aSb;
                            aVar2.Ki();
                        }
                    }
                    this.eWe.eWc = currentPosition;
                    this.eWe.aXK();
                }
            }
        }
    }
}
