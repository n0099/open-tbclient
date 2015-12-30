package com.baidu.tieba.pb.pb.a;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ n cEc;
    private final /* synthetic */ int cEg;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.r cEh;
    private final /* synthetic */ int val$count;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(n nVar, int i, int i2, com.baidu.tieba.tbadkCore.data.r rVar) {
        this.cEc = nVar;
        this.cEg = i;
        this.val$count = i2;
        this.cEh = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cEh.mZ(Math.min(this.cEg + 5, this.val$count));
        this.cEc.notifyDataSetChanged();
    }
}
