package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
import com.baidu.tieba.play.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends Handler {
    final /* synthetic */ h eYq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(h hVar, Looper looper) {
        super(looper);
        this.eYq = hVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        MediaController.MediaPlayerControl mediaPlayerControl;
        MediaController.MediaPlayerControl mediaPlayerControl2;
        MediaController.MediaPlayerControl mediaPlayerControl3;
        int i;
        int i2;
        h.b bVar;
        h.b bVar2;
        h.a aVar;
        h.a aVar2;
        if (message != null && message.what == 1) {
            mediaPlayerControl = this.eYq.aPl;
            if (mediaPlayerControl != null) {
                mediaPlayerControl2 = this.eYq.aPl;
                if (mediaPlayerControl2.isPlaying()) {
                    mediaPlayerControl3 = this.eYq.aPl;
                    int currentPosition = mediaPlayerControl3.getCurrentPosition();
                    i = this.eYq.eYo;
                    if (currentPosition >= i) {
                        i2 = this.eYq.eYo;
                        if (currentPosition == i2) {
                            bVar = this.eYq.eYp;
                            if (bVar != null) {
                                bVar2 = this.eYq.eYp;
                                bVar2.baj();
                            }
                        }
                    } else {
                        aVar = this.eYq.aMa;
                        if (aVar != null) {
                            aVar2 = this.eYq.aMa;
                            aVar2.Ju();
                        }
                    }
                    this.eYq.eYo = currentPosition;
                }
            }
            this.eYq.bai();
        }
    }
}
