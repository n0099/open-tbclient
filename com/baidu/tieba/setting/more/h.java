package com.baidu.tieba.setting.more;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ AppsActivity dtR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(AppsActivity appsActivity) {
        this.dtR = appsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dtR.refresh();
    }
}
