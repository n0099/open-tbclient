package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements View.OnClickListener {
    final /* synthetic */ VcodeActivity cxP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(VcodeActivity vcodeActivity) {
        this.cxP = vcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cxP.eV(null);
    }
}
