package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class eb implements View.OnClickListener {
    private final /* synthetic */ int enC;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.q enD;
    final /* synthetic */ du esD;
    private final /* synthetic */ int val$count;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eb(du duVar, int i, int i2, com.baidu.tieba.tbadkCore.data.q qVar) {
        this.esD = duVar;
        this.enC = i;
        this.val$count = i2;
        this.enD = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.enD.rN(Math.min(this.enC + 5, this.val$count));
        this.esD.notifyDataSetChanged();
    }
}
