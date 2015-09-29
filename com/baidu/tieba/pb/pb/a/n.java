package com.baidu.tieba.pb.pb.a;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    private final /* synthetic */ int cgR;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.k cgS;
    final /* synthetic */ k chD;
    private final /* synthetic */ int val$count;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k kVar, int i, int i2, com.baidu.tieba.tbadkCore.data.k kVar2) {
        this.chD = kVar;
        this.cgR = i;
        this.val$count = i2;
        this.cgS = kVar2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cgS.kV(Math.min(this.cgR + 5, this.val$count));
        this.chD.notifyDataSetChanged();
    }
}
