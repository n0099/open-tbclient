package com.baidu.tieba.more;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ AppsActivity bvg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AppsActivity appsActivity) {
        this.bvg = appsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bvg.refresh();
    }
}
