package com.baidu.tieba;

import android.view.View;
/* loaded from: classes.dex */
class v implements View.OnClickListener {
    final /* synthetic */ GuideActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(GuideActivity guideActivity) {
        this.a = guideActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        str = this.a.e;
        if (!str.equals("from_about_page")) {
            this.a.a();
        }
        this.a.closeActivity();
    }
}
