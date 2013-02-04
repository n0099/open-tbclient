package com.baidu.tieba.more;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ AppsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(AppsActivity appsActivity) {
        this.a = appsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.g();
    }
}
