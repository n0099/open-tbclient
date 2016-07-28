package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class eb implements View.OnClickListener {
    private final /* synthetic */ int dZB;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.s dZC;
    final /* synthetic */ du eey;
    private final /* synthetic */ int val$count;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eb(du duVar, int i, int i2, com.baidu.tieba.tbadkCore.data.s sVar) {
        this.eey = duVar;
        this.dZB = i;
        this.val$count = i2;
        this.dZC = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dZC.qZ(Math.min(this.dZB + 5, this.val$count));
        this.eey.notifyDataSetChanged();
    }
}
