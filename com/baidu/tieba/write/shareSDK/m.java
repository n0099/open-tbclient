package com.baidu.tieba.write.shareSDK;

import android.view.View;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity cvN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(WriteShareActivity writeShareActivity) {
        this.cvN = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        this.cvN.aqs();
        z = this.cvN.cvB;
        if (z) {
            this.cvN.setResult(-1);
        }
        com.baidu.tbadk.core.c.b.a(this.cvN.getPageContext().getPageActivity(), 200, false);
        this.cvN.finish();
    }
}
