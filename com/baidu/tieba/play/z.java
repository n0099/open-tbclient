package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
import com.baidu.tieba.play.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends Handler {
    final /* synthetic */ y eSt;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(y yVar, Looper looper) {
        super(looper);
        this.eSt = yVar;
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
            mediaPlayerControl = this.eSt.aXp;
            if (mediaPlayerControl != null) {
                mediaPlayerControl2 = this.eSt.aXp;
                if (mediaPlayerControl2.isPlaying()) {
                    mediaPlayerControl3 = this.eSt.aXp;
                    int currentPosition = mediaPlayerControl3.getCurrentPosition();
                    i = this.eSt.eSr;
                    if (currentPosition >= i) {
                        i2 = this.eSt.eSr;
                        if (currentPosition == i2) {
                            bVar = this.eSt.eSs;
                            if (bVar != null) {
                                bVar2 = this.eSt.eSs;
                                bVar2.aWu();
                            }
                        }
                    } else {
                        aVar = this.eSt.aSO;
                        if (aVar != null) {
                            aVar2 = this.eSt.aSO;
                            aVar2.JW();
                        }
                    }
                    this.eSt.eSr = currentPosition;
                    this.eSt.aWt();
                }
            }
        }
    }
}
