package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fu implements View.OnClickListener {
    final /* synthetic */ ex ewH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fu(ex exVar) {
        this.ewH = exVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        this.ewH.aQx();
        pbActivity = this.ewH.eow;
        if (pbActivity.bRx != null) {
            pbActivity2 = this.ewH.eow;
            pbActivity2.bRx.onClick(view);
        }
    }
}
