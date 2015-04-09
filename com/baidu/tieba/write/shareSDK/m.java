package com.baidu.tieba.write.shareSDK;

import android.view.View;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity cwd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(WriteShareActivity writeShareActivity) {
        this.cwd = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        this.cwd.aqH();
        z = this.cwd.cvR;
        if (z) {
            this.cwd.setResult(-1);
        }
        com.baidu.tbadk.core.c.b.a(this.cwd.getPageContext().getPageActivity(), 200, false);
        this.cwd.finish();
    }
}
