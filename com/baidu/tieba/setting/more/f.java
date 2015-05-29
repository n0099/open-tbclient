package com.baidu.tieba.setting.more;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ AppsActivity ceP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AppsActivity appsActivity) {
        this.ceP = appsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.ceP.refresh();
    }
}
