package com.baidu.tieba.write.shareSDK;

import android.view.View;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity epq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(WriteShareActivity writeShareActivity) {
        this.epq = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        this.epq.aTp();
        z = this.epq.epd;
        if (z) {
            this.epq.setResult(-1);
        }
        com.baidu.tbadk.core.c.b.b(this.epq.getPageContext().getPageActivity(), 200, false);
        this.epq.finish();
    }
}
