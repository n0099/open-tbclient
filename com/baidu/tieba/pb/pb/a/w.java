package com.baidu.tieba.pb.pb.a;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements MediaPlayer.OnCompletionListener {
    final /* synthetic */ r dej;
    private final /* synthetic */ an dek;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.s del;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(r rVar, an anVar, com.baidu.tieba.tbadkCore.data.s sVar) {
        this.dej = rVar;
        this.dek = anVar;
        this.del = sVar;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.dek.deD.setVisibility(0);
        this.dej.a(this.del, this.dek);
    }
}
