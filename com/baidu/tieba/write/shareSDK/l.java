package com.baidu.tieba.write.shareSDK;

import android.view.View;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity dNm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(WriteShareActivity writeShareActivity) {
        this.dNm = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        this.dNm.aIk();
        z = this.dNm.dMZ;
        if (z) {
            this.dNm.setResult(-1);
        }
        com.baidu.tbadk.core.c.b.b(this.dNm.getPageContext().getPageActivity(), 200, false);
        this.dNm.finish();
    }
}
