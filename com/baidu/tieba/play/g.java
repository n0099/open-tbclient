package com.baidu.tieba.play;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
import com.baidu.tieba.play.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends Handler {
    final /* synthetic */ f eWl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(f fVar, Looper looper) {
        super(looper);
        this.eWl = fVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        MediaController.MediaPlayerControl mediaPlayerControl;
        MediaController.MediaPlayerControl mediaPlayerControl2;
        MediaController.MediaPlayerControl mediaPlayerControl3;
        int i;
        f.a aVar;
        f.a aVar2;
        if (message != null && message.what == 1) {
            mediaPlayerControl = this.eWl.aOb;
            if (mediaPlayerControl != null) {
                mediaPlayerControl2 = this.eWl.aOb;
                if (mediaPlayerControl2.isPlaying()) {
                    mediaPlayerControl3 = this.eWl.aOb;
                    int currentPosition = mediaPlayerControl3.getCurrentPosition();
                    i = this.eWl.eWk;
                    if (currentPosition < i) {
                        aVar = this.eWl.aZD;
                        if (aVar != null) {
                            aVar2 = this.eWl.aZD;
                            aVar2.NB();
                        }
                    }
                    this.eWl.eWk = currentPosition;
                }
            }
            this.eWl.aZK();
        }
    }
}
