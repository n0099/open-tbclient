package com.baidu.tieba.more;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ AppsActivity bvh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AppsActivity appsActivity) {
        this.bvh = appsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bvh.refresh();
    }
}
