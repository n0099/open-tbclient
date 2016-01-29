package com.baidu.tieba.pb.pb.a;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ q cKS;
    private final /* synthetic */ am cKT;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.r cKU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(q qVar, am amVar, com.baidu.tieba.tbadkCore.data.r rVar) {
        this.cKS = qVar;
        this.cKT = amVar;
        this.cKU = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cKT.cLk.isPlaying()) {
            this.cKT.cLk.pause();
            this.cKT.cLp.setVisibility(0);
            return;
        }
        this.cKS.a(this.cKT, this.cKU);
    }
}
