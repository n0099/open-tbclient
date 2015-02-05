package com.baidu.tieba.pb.main;

import android.view.View;
/* loaded from: classes.dex */
class bm implements View.OnClickListener {
    final /* synthetic */ bi bBs;
    private final /* synthetic */ int bBu;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.b.k bBv;
    private final /* synthetic */ int val$count;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bi biVar, int i, int i2, com.baidu.tieba.tbadkCore.b.k kVar) {
        this.bBs = biVar;
        this.bBu = i;
        this.val$count = i2;
        this.bBv = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bBv.hY(Math.min(this.bBu + 5, this.val$count));
        this.bBs.notifyDataSetChanged();
    }
}
