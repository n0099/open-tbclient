package com.baidu.tieba.pb.pb.a;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements View.OnClickListener {
    final /* synthetic */ ao deL;
    private final /* synthetic */ int deM;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.s deN;
    private final /* synthetic */ int val$count;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ao aoVar, int i, int i2, com.baidu.tieba.tbadkCore.data.s sVar) {
        this.deL = aoVar;
        this.deM = i;
        this.val$count = i2;
        this.deN = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.deN.pu(Math.min(this.deM + 5, this.val$count));
        this.deL.notifyDataSetChanged();
    }
}
