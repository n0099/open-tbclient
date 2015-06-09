package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cr implements View.OnClickListener {
    final /* synthetic */ ch bOG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cr(ch chVar) {
        this.bOG = chVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        boolean z;
        pbActivity = this.bOG.bLa;
        if (pbActivity.checkUpIsLogin()) {
            this.bOG.WP();
            if (this.bOG.bKM != null) {
                bd bdVar = this.bOG.bKM;
                z = this.bOG.bLj;
                bdVar.dS(z);
            }
            this.bOG.acp();
        }
    }
}
