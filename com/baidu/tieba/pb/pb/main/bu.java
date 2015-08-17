package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu implements View.OnClickListener {
    final /* synthetic */ br ccK;
    private final /* synthetic */ int ccO;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.i ccP;
    private final /* synthetic */ int val$count;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(br brVar, int i, int i2, com.baidu.tieba.tbadkCore.data.i iVar) {
        this.ccK = brVar;
        this.ccO = i;
        this.val$count = i2;
        this.ccP = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.ccP.jJ(Math.min(this.ccO + 5, this.val$count));
        this.ccK.notifyDataSetChanged();
    }
}
