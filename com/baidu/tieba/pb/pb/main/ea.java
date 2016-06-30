package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ea implements View.OnClickListener {
    private final /* synthetic */ int dNo;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.s dNp;
    final /* synthetic */ dt dSh;
    private final /* synthetic */ int val$count;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ea(dt dtVar, int i, int i2, com.baidu.tieba.tbadkCore.data.s sVar) {
        this.dSh = dtVar;
        this.dNo = i;
        this.val$count = i2;
        this.dNp = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dNp.qE(Math.min(this.dNo + 5, this.val$count));
        this.dSh.notifyDataSetChanged();
    }
}
