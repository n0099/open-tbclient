package com.baidu.tieba.launcherGuide.tblauncher;

import android.view.View;
/* loaded from: classes2.dex */
class b implements View.OnClickListener {
    final /* synthetic */ GuideActivity dsp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(GuideActivity guideActivity) {
        this.dsp = guideActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dsp.avO();
    }
}
