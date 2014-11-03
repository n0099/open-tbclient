package com.baidu.tieba.pb.main;

import android.view.View;
/* loaded from: classes.dex */
class bj implements View.OnClickListener {
    private final /* synthetic */ int bjn;
    final /* synthetic */ bh bvU;
    private final /* synthetic */ int bvV;
    private final /* synthetic */ com.baidu.tieba.data.ak bvW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(bh bhVar, int i, int i2, com.baidu.tieba.data.ak akVar) {
        this.bvU = bhVar;
        this.bvV = i;
        this.bjn = i2;
        this.bvW = akVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bvW.eh(Math.min(this.bvV + 5, this.bjn));
        this.bvU.notifyDataSetChanged();
    }
}
