package com.baidu.tieba.setting.more;

import android.view.View;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    final /* synthetic */ AppsActivity cae;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(AppsActivity appsActivity) {
        this.cae = appsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cae.finish();
    }
}
