package com.baidu.tieba.pb.main;

import android.view.View;
/* loaded from: classes.dex */
class bm implements View.OnClickListener {
    final /* synthetic */ bi bzJ;
    private final /* synthetic */ int bzL;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.b.k bzM;
    private final /* synthetic */ int val$count;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bi biVar, int i, int i2, com.baidu.tieba.tbadkCore.b.k kVar) {
        this.bzJ = biVar;
        this.bzL = i;
        this.val$count = i2;
        this.bzM = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bzM.hP(Math.min(this.bzL + 5, this.val$count));
        this.bzJ.notifyDataSetChanged();
    }
}
