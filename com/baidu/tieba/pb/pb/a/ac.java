package com.baidu.tieba.pb.pb.a;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {
    final /* synthetic */ z dNn;
    private final /* synthetic */ int dNo;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.s dNp;
    private final /* synthetic */ int val$count;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(z zVar, int i, int i2, com.baidu.tieba.tbadkCore.data.s sVar) {
        this.dNn = zVar;
        this.dNo = i;
        this.val$count = i2;
        this.dNp = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dNp.qE(Math.min(this.dNo + 5, this.val$count));
        this.dNn.notifyDataSetChanged();
    }
}
