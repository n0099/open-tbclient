package com.baidu.tieba.pb.pb.a;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {
    final /* synthetic */ z elE;
    private final /* synthetic */ int elF;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.q elG;
    private final /* synthetic */ int val$count;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(z zVar, int i, int i2, com.baidu.tieba.tbadkCore.data.q qVar) {
        this.elE = zVar;
        this.elF = i;
        this.val$count = i2;
        this.elG = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.elG.rz(Math.min(this.elF + 5, this.val$count));
        this.elE.notifyDataSetChanged();
    }
}
