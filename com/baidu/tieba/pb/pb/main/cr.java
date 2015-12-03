package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cr implements View.OnClickListener {
    private final /* synthetic */ int cAB;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.o cAC;
    final /* synthetic */ cn cDY;
    private final /* synthetic */ int val$count;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cr(cn cnVar, int i, int i2, com.baidu.tieba.tbadkCore.data.o oVar) {
        this.cDY = cnVar;
        this.cAB = i;
        this.val$count = i2;
        this.cAC = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cAC.mx(Math.min(this.cAB + 5, this.val$count));
        this.cDY.notifyDataSetChanged();
    }
}
