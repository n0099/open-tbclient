package com.baidu.tieba.pb.pb.a;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements MediaPlayer.OnErrorListener {
    final /* synthetic */ e elb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar) {
        this.elb = eVar;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        this.elb.d(true, 4);
        return true;
    }
}
