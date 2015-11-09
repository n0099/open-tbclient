package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {
    final /* synthetic */ VcodeActivity drb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(VcodeActivity vcodeActivity) {
        this.drb = vcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.drb.mA(null);
    }
}
