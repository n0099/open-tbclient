package com.baidu.tieba.pb.pb.a;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ f chM;
    private final /* synthetic */ int chc;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.k chd;
    private final /* synthetic */ int val$count;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar, int i, int i2, com.baidu.tieba.tbadkCore.data.k kVar) {
        this.chM = fVar;
        this.chc = i;
        this.val$count = i2;
        this.chd = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.chd.kX(Math.min(this.chc + 5, this.val$count));
        this.chM.notifyDataSetChanged();
    }
}
