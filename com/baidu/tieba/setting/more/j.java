package com.baidu.tieba.setting.more;

import android.view.View;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    final /* synthetic */ AppsActivity cMt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(AppsActivity appsActivity) {
        this.cMt = appsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cMt.finish();
    }
}
