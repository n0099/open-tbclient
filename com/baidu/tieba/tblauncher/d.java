package com.baidu.tieba.tblauncher;

import android.view.View;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ GuideActivity bOn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(GuideActivity guideActivity) {
        this.bOn = guideActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bOn.adZ();
    }
}
