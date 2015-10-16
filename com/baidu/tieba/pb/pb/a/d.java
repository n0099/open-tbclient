package com.baidu.tieba.pb.pb.a;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a cgY;
    private final /* synthetic */ int chc;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.k chd;
    private final /* synthetic */ int val$count;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, int i, int i2, com.baidu.tieba.tbadkCore.data.k kVar) {
        this.cgY = aVar;
        this.chc = i;
        this.val$count = i2;
        this.chd = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.chd.kX(Math.min(this.chc + 5, this.val$count));
        this.cgY.notifyDataSetChanged();
    }
}
