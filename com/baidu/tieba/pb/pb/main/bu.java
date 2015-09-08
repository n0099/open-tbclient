package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu implements View.OnClickListener {
    final /* synthetic */ br cdH;
    private final /* synthetic */ int cdL;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.i cdM;
    private final /* synthetic */ int val$count;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(br brVar, int i, int i2, com.baidu.tieba.tbadkCore.data.i iVar) {
        this.cdH = brVar;
        this.cdL = i;
        this.val$count = i2;
        this.cdM = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cdM.ku(Math.min(this.cdL + 5, this.val$count));
        this.cdH.notifyDataSetChanged();
    }
}
