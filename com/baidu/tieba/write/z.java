package com.baidu.tieba.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ VcodeActivity cgm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(VcodeActivity vcodeActivity) {
        this.cgm = vcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cgm.de(null);
    }
}
