package com.baidu.tieba.pb.pb.a;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ n cia;
    private final /* synthetic */ int cif;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.o cig;
    private final /* synthetic */ int val$count;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(n nVar, int i, int i2, com.baidu.tieba.tbadkCore.data.o oVar) {
        this.cia = nVar;
        this.cif = i;
        this.val$count = i2;
        this.cig = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cig.ll(Math.min(this.cif + 5, this.val$count));
        this.cia.notifyDataSetChanged();
    }
}
