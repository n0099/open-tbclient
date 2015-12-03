package com.baidu.tieba.pb.pb.a;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    private final /* synthetic */ int cAB;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.o cAC;
    final /* synthetic */ n cAx;
    private final /* synthetic */ int val$count;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(n nVar, int i, int i2, com.baidu.tieba.tbadkCore.data.o oVar) {
        this.cAx = nVar;
        this.cAB = i;
        this.val$count = i2;
        this.cAC = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cAC.mx(Math.min(this.cAB + 5, this.val$count));
        this.cAx.notifyDataSetChanged();
    }
}
