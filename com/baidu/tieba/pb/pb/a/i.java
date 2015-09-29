package com.baidu.tieba.pb.pb.a;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    private final /* synthetic */ int cgR;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.k cgS;
    final /* synthetic */ f chB;
    private final /* synthetic */ int val$count;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar, int i, int i2, com.baidu.tieba.tbadkCore.data.k kVar) {
        this.chB = fVar;
        this.cgR = i;
        this.val$count = i2;
        this.cgS = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cgS.kV(Math.min(this.cgR + 5, this.val$count));
        this.chB.notifyDataSetChanged();
    }
}
