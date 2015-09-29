package com.baidu.tieba.write.shareSDK;

import android.view.View;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity dlY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(WriteShareActivity writeShareActivity) {
        this.dlY = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        this.dlY.aBR();
        z = this.dlY.dlL;
        if (z) {
            this.dlY.setResult(-1);
        }
        com.baidu.tbadk.core.c.b.b(this.dlY.getPageContext().getPageActivity(), 200, false);
        this.dlY.finish();
    }
}
