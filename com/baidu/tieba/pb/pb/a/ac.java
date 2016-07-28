package com.baidu.tieba.pb.pb.a;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {
    final /* synthetic */ z dZA;
    private final /* synthetic */ int dZB;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.s dZC;
    private final /* synthetic */ int val$count;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(z zVar, int i, int i2, com.baidu.tieba.tbadkCore.data.s sVar) {
        this.dZA = zVar;
        this.dZB = i;
        this.val$count = i2;
        this.dZC = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dZC.qZ(Math.min(this.dZB + 5, this.val$count));
        this.dZA.notifyDataSetChanged();
    }
}
