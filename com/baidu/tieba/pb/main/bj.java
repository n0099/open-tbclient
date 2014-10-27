package com.baidu.tieba.pb.main;

import android.view.View;
/* loaded from: classes.dex */
class bj implements View.OnClickListener {
    private final /* synthetic */ int biZ;
    final /* synthetic */ bh bvG;
    private final /* synthetic */ int bvH;
    private final /* synthetic */ com.baidu.tieba.data.ak bvI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(bh bhVar, int i, int i2, com.baidu.tieba.data.ak akVar) {
        this.bvG = bhVar;
        this.bvH = i;
        this.biZ = i2;
        this.bvI = akVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bvI.eh(Math.min(this.bvH + 5, this.biZ));
        this.bvG.notifyDataSetChanged();
    }
}
