package com.baidu.tieba.launcherGuide.tblauncher;

import android.view.View;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ GuideActivity bxO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(GuideActivity guideActivity) {
        this.bxO = guideActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bxO.Wx();
    }
}
