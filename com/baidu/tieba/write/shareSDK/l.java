package com.baidu.tieba.write.shareSDK;

import android.view.View;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity fFg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(WriteShareActivity writeShareActivity) {
        this.fFg = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        this.fFg.bkD();
        z = this.fFg.fET;
        if (z) {
            this.fFg.setResult(-1);
        }
        com.baidu.tbadk.core.d.b.c(this.fFg.getPageContext().getPageActivity(), 200, false);
        this.fFg.finish();
    }
}
