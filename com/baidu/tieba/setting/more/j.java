package com.baidu.tieba.setting.more;

import android.view.View;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    final /* synthetic */ AppsActivity cFs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(AppsActivity appsActivity) {
        this.cFs = appsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cFs.finish();
    }
}
