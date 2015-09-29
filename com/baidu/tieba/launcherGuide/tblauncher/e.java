package com.baidu.tieba.launcherGuide.tblauncher;

import android.view.View;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ GuideActivity bSz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(GuideActivity guideActivity) {
        this.bSz = guideActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bSz.FY();
    }
}
