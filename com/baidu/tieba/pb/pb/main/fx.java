package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fx implements View.OnClickListener {
    final /* synthetic */ ey erv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fx(ey eyVar) {
        this.erv = eyVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        this.erv.aNE();
        pbActivity = this.erv.eig;
        if (pbActivity.bOx != null) {
            pbActivity2 = this.erv.eig;
            pbActivity2.bOx.onClick(view);
        }
    }
}
