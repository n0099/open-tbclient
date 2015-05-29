package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bz implements View.OnClickListener {
    final /* synthetic */ bw bMi;
    private final /* synthetic */ int bMm;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.j bMn;
    private final /* synthetic */ int val$count;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(bw bwVar, int i, int i2, com.baidu.tieba.tbadkCore.data.j jVar) {
        this.bMi = bwVar;
        this.bMm = i;
        this.val$count = i2;
        this.bMn = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bMn.iR(Math.min(this.bMm + 5, this.val$count));
        this.bMi.notifyDataSetChanged();
    }
}
