package com.baidu.tieba.write.shareSDK;

import android.view.View;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity daW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(WriteShareActivity writeShareActivity) {
        this.daW = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        this.daW.ayI();
        z = this.daW.daJ;
        if (z) {
            this.daW.setResult(-1);
        }
        com.baidu.tbadk.core.c.b.a(this.daW.getPageContext().getPageActivity(), 200, false);
        this.daW.finish();
    }
}
