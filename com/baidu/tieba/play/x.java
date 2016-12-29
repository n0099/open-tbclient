package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
import com.baidu.tieba.play.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends Handler {
    final /* synthetic */ w eIV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(w wVar, Looper looper) {
        super(looper);
        this.eIV = wVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        MediaController.MediaPlayerControl mediaPlayerControl;
        MediaController.MediaPlayerControl mediaPlayerControl2;
        MediaController.MediaPlayerControl mediaPlayerControl3;
        int i;
        int i2;
        w.b bVar;
        w.b bVar2;
        w.a aVar;
        w.a aVar2;
        if (message != null && message.what == 1) {
            mediaPlayerControl = this.eIV.aQI;
            if (mediaPlayerControl != null) {
                mediaPlayerControl2 = this.eIV.aQI;
                if (mediaPlayerControl2.isPlaying()) {
                    mediaPlayerControl3 = this.eIV.aQI;
                    int currentPosition = mediaPlayerControl3.getCurrentPosition();
                    i = this.eIV.eIT;
                    if (currentPosition >= i) {
                        i2 = this.eIV.eIT;
                        if (currentPosition == i2) {
                            bVar = this.eIV.eIU;
                            if (bVar != null) {
                                bVar2 = this.eIV.eIU;
                                bVar2.aWp();
                            }
                        }
                    } else {
                        aVar = this.eIV.aNm;
                        if (aVar != null) {
                            aVar2 = this.eIV.aNm;
                            aVar2.Jp();
                        }
                    }
                    this.eIV.eIT = currentPosition;
                    this.eIV.aWo();
                }
            }
        }
    }
}
