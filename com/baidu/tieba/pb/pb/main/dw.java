package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dw implements View.OnClickListener {
    private final /* synthetic */ int dhf;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.s dhg;
    final /* synthetic */ dq dmt;
    private final /* synthetic */ int val$count;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dw(dq dqVar, int i, int i2, com.baidu.tieba.tbadkCore.data.s sVar) {
        this.dmt = dqVar;
        this.dhf = i;
        this.val$count = i2;
        this.dhg = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dhg.pp(Math.min(this.dhf + 5, this.val$count));
        this.dmt.notifyDataSetChanged();
    }
}
