package com.baidu.tieba.more;

import android.view.View;
/* loaded from: classes.dex */
class r implements View.OnClickListener {
    final /* synthetic */ AppsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(AppsActivity appsActivity) {
        this.a = appsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.finish();
    }
}
