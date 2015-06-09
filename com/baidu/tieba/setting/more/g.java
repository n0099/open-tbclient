package com.baidu.tieba.setting.more;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ AppsActivity ceQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AppsActivity appsActivity) {
        this.ceQ = appsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.ceQ.refresh();
    }
}
