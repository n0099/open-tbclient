package com.baidu.tieba.setting.more;

import android.view.View;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    final /* synthetic */ AppsActivity dmF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(AppsActivity appsActivity) {
        this.dmF = appsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dmF.finish();
    }
}
