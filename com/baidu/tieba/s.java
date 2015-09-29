package com.baidu.tieba;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ UpdateDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(UpdateDialog updateDialog) {
        this.this$0 = updateDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        boolean z3;
        this.this$0.aEb.FL();
        UpdateDialog updateDialog = this.this$0;
        z = this.this$0.aDW;
        z2 = this.this$0.aDX;
        z3 = this.this$0.aDY;
        updateDialog.b(z, z2, z3);
    }
}
