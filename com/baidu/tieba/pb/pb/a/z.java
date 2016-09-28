package com.baidu.tieba.pb.pb.a;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ w enB;
    private final /* synthetic */ int enC;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.q enD;
    private final /* synthetic */ int val$count;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(w wVar, int i, int i2, com.baidu.tieba.tbadkCore.data.q qVar) {
        this.enB = wVar;
        this.enC = i;
        this.val$count = i2;
        this.enD = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.enD.rN(Math.min(this.enC + 5, this.val$count));
        this.enB.notifyDataSetChanged();
    }
}
