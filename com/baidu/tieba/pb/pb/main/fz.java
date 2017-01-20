package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fz implements View.OnClickListener {
    final /* synthetic */ ez eqf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fz(ez ezVar) {
        this.eqf = ezVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        this.eqf.aOb();
        pbActivity = this.eqf.ehi;
        if (pbActivity.bHz != null) {
            pbActivity2 = this.eqf.ehi;
            pbActivity2.bHz.onClick(view);
        }
    }
}
