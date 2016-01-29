package com.baidu.tieba.pb.pb.a;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements MediaPlayer.OnCompletionListener {
    final /* synthetic */ q cKS;
    private final /* synthetic */ am cKT;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.r cKU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(q qVar, am amVar, com.baidu.tieba.tbadkCore.data.r rVar) {
        this.cKS = qVar;
        this.cKT = amVar;
        this.cKU = rVar;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.cKT.cLn.setVisibility(0);
        this.cKS.a(this.cKU, this.cKT);
    }
}
