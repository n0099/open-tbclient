package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
import com.baidu.tieba.play.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends Handler {
    final /* synthetic */ y eWt;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(y yVar, Looper looper) {
        super(looper);
        this.eWt = yVar;
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
            mediaPlayerControl = this.eWt.aWT;
            if (mediaPlayerControl != null) {
                mediaPlayerControl2 = this.eWt.aWT;
                if (mediaPlayerControl2.isPlaying()) {
                    mediaPlayerControl3 = this.eWt.aWT;
                    int currentPosition = mediaPlayerControl3.getCurrentPosition();
                    i = this.eWt.eWr;
                    if (currentPosition >= i) {
                        i2 = this.eWt.eWr;
                        if (currentPosition == i2) {
                            bVar = this.eWt.eWs;
                            if (bVar != null) {
                                bVar2 = this.eWt.eWs;
                                bVar2.aYV();
                            }
                        }
                    } else {
                        aVar = this.eWt.aSt;
                        if (aVar != null) {
                            aVar2 = this.eWt.aSt;
                            aVar2.KI();
                        }
                    }
                    this.eWt.eWr = currentPosition;
                    this.eWt.aYU();
                }
            }
        }
    }
}
