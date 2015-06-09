package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bz implements View.OnClickListener {
    final /* synthetic */ bw bMj;
    private final /* synthetic */ int bMn;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.j bMo;
    private final /* synthetic */ int val$count;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(bw bwVar, int i, int i2, com.baidu.tieba.tbadkCore.data.j jVar) {
        this.bMj = bwVar;
        this.bMn = i;
        this.val$count = i2;
        this.bMo = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bMo.iR(Math.min(this.bMn + 5, this.val$count));
        this.bMj.notifyDataSetChanged();
    }
}
