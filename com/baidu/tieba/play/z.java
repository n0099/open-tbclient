package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
import com.baidu.tieba.play.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends Handler {
    final /* synthetic */ y eUd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(y yVar, Looper looper) {
        super(looper);
        this.eUd = yVar;
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
            mediaPlayerControl = this.eUd.aWQ;
            if (mediaPlayerControl != null) {
                mediaPlayerControl2 = this.eUd.aWQ;
                if (mediaPlayerControl2.isPlaying()) {
                    mediaPlayerControl3 = this.eUd.aWQ;
                    int currentPosition = mediaPlayerControl3.getCurrentPosition();
                    i = this.eUd.eUb;
                    if (currentPosition >= i) {
                        i2 = this.eUd.eUb;
                        if (currentPosition == i2) {
                            bVar = this.eUd.eUc;
                            if (bVar != null) {
                                bVar2 = this.eUd.eUc;
                                bVar2.aXU();
                            }
                        }
                    } else {
                        aVar = this.eUd.aSr;
                        if (aVar != null) {
                            aVar2 = this.eUd.aSr;
                            aVar2.KI();
                        }
                    }
                    this.eUd.eUb = currentPosition;
                    this.eUd.aXT();
                }
            }
        }
    }
}
