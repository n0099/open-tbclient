package com.baidu.tieba.more;

import android.view.View;
/* loaded from: classes.dex */
class u implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AppsActivity f2104a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(AppsActivity appsActivity) {
        this.f2104a = appsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2104a.finish();
    }
}
