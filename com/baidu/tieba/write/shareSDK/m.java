package com.baidu.tieba.write.shareSDK;

import android.view.View;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity cAt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(WriteShareActivity writeShareActivity) {
        this.cAt = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        this.cAt.asx();
        z = this.cAt.cAh;
        if (z) {
            this.cAt.setResult(-1);
        }
        com.baidu.tbadk.core.c.b.a(this.cAt.getPageContext().getPageActivity(), 200, false);
        this.cAt.finish();
    }
}
