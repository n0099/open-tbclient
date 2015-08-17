package com.baidu.tieba.write.shareSDK;

import android.view.View;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity cSj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(WriteShareActivity writeShareActivity) {
        this.cSj = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        this.cSj.auo();
        z = this.cSj.cRW;
        if (z) {
            this.cSj.setResult(-1);
        }
        com.baidu.tbadk.core.c.b.a(this.cSj.getPageContext().getPageActivity(), 200, false);
        this.cSj.finish();
    }
}
