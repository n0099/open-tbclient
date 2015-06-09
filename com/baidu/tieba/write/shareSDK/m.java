package com.baidu.tieba.write.shareSDK;

import android.view.View;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity cAu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(WriteShareActivity writeShareActivity) {
        this.cAu = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        this.cAu.asy();
        z = this.cAu.cAi;
        if (z) {
            this.cAu.setResult(-1);
        }
        com.baidu.tbadk.core.c.b.a(this.cAu.getPageContext().getPageActivity(), 200, false);
        this.cAu.finish();
    }
}
