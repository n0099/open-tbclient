package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class eb implements View.OnClickListener {
    private final /* synthetic */ int elF;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.q elG;
    final /* synthetic */ du eqD;
    private final /* synthetic */ int val$count;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eb(du duVar, int i, int i2, com.baidu.tieba.tbadkCore.data.q qVar) {
        this.eqD = duVar;
        this.elF = i;
        this.val$count = i2;
        this.elG = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.elG.rz(Math.min(this.elF + 5, this.val$count));
        this.eqD.notifyDataSetChanged();
    }
}
