package com.baidu.tieba.more;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ AppsActivity btK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AppsActivity appsActivity) {
        this.btK = appsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.btK.refresh();
    }
}
