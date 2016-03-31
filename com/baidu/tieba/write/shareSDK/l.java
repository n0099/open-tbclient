package com.baidu.tieba.write.shareSDK;

import android.view.View;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity eJm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(WriteShareActivity writeShareActivity) {
        this.eJm = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        this.eJm.aZP();
        z = this.eJm.eIZ;
        if (z) {
            this.eJm.setResult(-1);
        }
        com.baidu.tbadk.core.d.b.b(this.eJm.getPageContext().getPageActivity(), 200, false);
        this.eJm.finish();
    }
}
