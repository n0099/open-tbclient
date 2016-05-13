package com.baidu.tieba.write.shareSDK;

import android.view.View;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity fac;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(WriteShareActivity writeShareActivity) {
        this.fac = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        this.fac.bci();
        z = this.fac.eZP;
        if (z) {
            this.fac.setResult(-1);
        }
        com.baidu.tbadk.core.e.b.b(this.fac.getPageContext().getPageActivity(), 200, false);
        this.fac.finish();
    }
}
