package com.baidu.tieba.write.shareSDK;

import android.view.View;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity fad;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(WriteShareActivity writeShareActivity) {
        this.fad = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        this.fad.bcb();
        z = this.fad.eZQ;
        if (z) {
            this.fad.setResult(-1);
        }
        com.baidu.tbadk.core.e.b.b(this.fad.getPageContext().getPageActivity(), 200, false);
        this.fad.finish();
    }
}
