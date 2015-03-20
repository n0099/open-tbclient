package com.baidu.tieba.launcherGuide.tblauncher;

import android.view.View;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ GuideActivity bxy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(GuideActivity guideActivity) {
        this.bxy = guideActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bxy.Wk();
    }
}
