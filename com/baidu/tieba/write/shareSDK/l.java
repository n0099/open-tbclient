package com.baidu.tieba.write.shareSDK;

import android.view.View;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity dUL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(WriteShareActivity writeShareActivity) {
        this.dUL = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        this.dUL.aKF();
        z = this.dUL.dUy;
        if (z) {
            this.dUL.setResult(-1);
        }
        com.baidu.tbadk.core.c.b.b(this.dUL.getPageContext().getPageActivity(), 200, false);
        this.dUL.finish();
    }
}
