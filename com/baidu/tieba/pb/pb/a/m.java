package com.baidu.tieba.pb.pb.a;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements MediaPlayer.OnCompletionListener {
    final /* synthetic */ e dML;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(e eVar) {
        this.dML = eVar;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.dML.aEt();
    }
}
