package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fu implements View.OnClickListener {
    final /* synthetic */ ex euB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fu(ex exVar) {
        this.euB = exVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        this.euB.aPO();
        pbActivity = this.euB.emy;
        if (pbActivity.bRE != null) {
            pbActivity2 = this.euB.emy;
            pbActivity2.bRE.onClick(view);
        }
    }
}
