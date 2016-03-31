package com.baidu.tieba.setting.more;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ AppsActivity ecp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(AppsActivity appsActivity) {
        this.ecp = appsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.ecp.refresh();
    }
}
