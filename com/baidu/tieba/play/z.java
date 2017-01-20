package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
import com.baidu.tieba.play.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends Handler {
    final /* synthetic */ y eSx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(y yVar, Looper looper) {
        super(looper);
        this.eSx = yVar;
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
            mediaPlayerControl = this.eSx.cKv;
            if (mediaPlayerControl != null) {
                mediaPlayerControl2 = this.eSx.cKv;
                if (mediaPlayerControl2.isPlaying()) {
                    mediaPlayerControl3 = this.eSx.cKv;
                    int currentPosition = mediaPlayerControl3.getCurrentPosition();
                    i = this.eSx.eSv;
                    if (currentPosition >= i) {
                        i2 = this.eSx.eSv;
                        if (currentPosition == i2) {
                            bVar = this.eSx.eSw;
                            if (bVar != null) {
                                bVar2 = this.eSx.eSw;
                                bVar2.aYh();
                            }
                        }
                    } else {
                        aVar = this.eSx.aMo;
                        if (aVar != null) {
                            aVar2 = this.eSx.aMo;
                            aVar2.JD();
                        }
                    }
                    this.eSx.eSv = currentPosition;
                    this.eSx.aYg();
                }
            }
        }
    }
}
