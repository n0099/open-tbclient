package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc implements View.OnClickListener {
    final /* synthetic */ bz bKc;
    private final /* synthetic */ int bKg;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.c.j bKh;
    private final /* synthetic */ int val$count;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(bz bzVar, int i, int i2, com.baidu.tieba.tbadkCore.c.j jVar) {
        this.bKc = bzVar;
        this.bKg = i;
        this.val$count = i2;
        this.bKh = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bKh.iv(Math.min(this.bKg + 5, this.val$count));
        this.bKc.notifyDataSetChanged();
    }
}
