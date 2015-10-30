package com.baidu.tieba.write.shareSDK;

import android.view.View;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity dmy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(WriteShareActivity writeShareActivity) {
        this.dmy = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        this.dmy.aBX();
        z = this.dmy.dml;
        if (z) {
            this.dmy.setResult(-1);
        }
        com.baidu.tbadk.core.c.b.b(this.dmy.getPageContext().getPageActivity(), 200, false);
        this.dmy.finish();
    }
}
