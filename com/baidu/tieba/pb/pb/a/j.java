package com.baidu.tieba.pb.pb.a;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements MediaPlayer.OnErrorListener {
    final /* synthetic */ e dYX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar) {
        this.dYX = eVar;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        this.dYX.e(true, 4);
        return true;
    }
}
