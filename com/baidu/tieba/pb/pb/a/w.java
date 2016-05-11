package com.baidu.tieba.pb.pb.a;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements MediaPlayer.OnCompletionListener {
    final /* synthetic */ r dgC;
    private final /* synthetic */ an dgD;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.s dgE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(r rVar, an anVar, com.baidu.tieba.tbadkCore.data.s sVar) {
        this.dgC = rVar;
        this.dgD = anVar;
        this.dgE = sVar;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.dgD.dgW.setVisibility(0);
        this.dgC.a(this.dgE, this.dgD);
    }
}
