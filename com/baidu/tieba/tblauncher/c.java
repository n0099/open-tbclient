package com.baidu.tieba.tblauncher;

import android.view.View;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ GuideActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(GuideActivity guideActivity) {
        this.a = guideActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        str = this.a.f;
        if (!str.equals("from_about_page")) {
            this.a.e();
        }
        this.a.closeActivity();
    }
}
