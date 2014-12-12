package com.baidu.tieba.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ VcodeActivity ceN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(VcodeActivity vcodeActivity) {
        this.ceN = vcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.ceN.df(null);
    }
}
