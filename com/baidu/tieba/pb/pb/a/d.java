package com.baidu.tieba.pb.pb.a;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a cgN;
    private final /* synthetic */ int cgR;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.k cgS;
    private final /* synthetic */ int val$count;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, int i, int i2, com.baidu.tieba.tbadkCore.data.k kVar) {
        this.cgN = aVar;
        this.cgR = i;
        this.val$count = i2;
        this.cgS = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cgS.kV(Math.min(this.cgR + 5, this.val$count));
        this.cgN.notifyDataSetChanged();
    }
}
