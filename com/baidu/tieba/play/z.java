package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
import com.baidu.tieba.play.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends Handler {
    final /* synthetic */ y flu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(y yVar, Looper looper) {
        super(looper);
        this.flu = yVar;
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
            mediaPlayerControl = this.flu.aWk;
            if (mediaPlayerControl != null) {
                mediaPlayerControl2 = this.flu.aWk;
                if (mediaPlayerControl2.isPlaying()) {
                    mediaPlayerControl3 = this.flu.aWk;
                    int currentPosition = mediaPlayerControl3.getCurrentPosition();
                    i = this.flu.fls;
                    if (currentPosition >= i) {
                        i2 = this.flu.fls;
                        if (currentPosition == i2) {
                            bVar = this.flu.flt;
                            if (bVar != null) {
                                bVar2 = this.flu.flt;
                                bVar2.bbV();
                            }
                        }
                    } else {
                        aVar = this.flu.bBS;
                        if (aVar != null) {
                            aVar2 = this.flu.bBS;
                            aVar2.VF();
                        }
                    }
                    this.flu.fls = currentPosition;
                    this.flu.bbU();
                }
            }
        }
    }
}
