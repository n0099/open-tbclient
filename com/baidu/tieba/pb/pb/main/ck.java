package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ck implements View.OnClickListener {
    private final /* synthetic */ int cif;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.o cig;
    final /* synthetic */ ch cln;
    private final /* synthetic */ int val$count;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(ch chVar, int i, int i2, com.baidu.tieba.tbadkCore.data.o oVar) {
        this.cln = chVar;
        this.cif = i;
        this.val$count = i2;
        this.cig = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cig.ll(Math.min(this.cif + 5, this.val$count));
        this.cln.notifyDataSetChanged();
    }
}
