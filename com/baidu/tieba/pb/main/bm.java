package com.baidu.tieba.pb.main;

import android.view.View;
/* loaded from: classes.dex */
class bm implements View.OnClickListener {
    final /* synthetic */ bi bBt;
    private final /* synthetic */ int bBv;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.b.k bBw;
    private final /* synthetic */ int val$count;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bi biVar, int i, int i2, com.baidu.tieba.tbadkCore.b.k kVar) {
        this.bBt = biVar;
        this.bBv = i;
        this.val$count = i2;
        this.bBw = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bBw.hY(Math.min(this.bBv + 5, this.val$count));
        this.bBt.notifyDataSetChanged();
    }
}
