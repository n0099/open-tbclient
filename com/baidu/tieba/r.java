package com.baidu.tieba;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ UpdateDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(UpdateDialog updateDialog) {
        this.this$0 = updateDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        z = this.this$0.aCA;
        if (z) {
            this.this$0.FI();
        }
        this.this$0.aDg.dismiss();
        this.this$0.finish();
    }
}
