package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cr implements View.OnClickListener {
    final /* synthetic */ ch bOF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cr(ch chVar) {
        this.bOF = chVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        boolean z;
        pbActivity = this.bOF.bKZ;
        if (pbActivity.checkUpIsLogin()) {
            this.bOF.WO();
            if (this.bOF.bKL != null) {
                bd bdVar = this.bOF.bKL;
                z = this.bOF.bLi;
                bdVar.dS(z);
            }
            this.bOF.aco();
        }
    }
}
