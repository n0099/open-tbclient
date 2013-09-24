package com.baidu.tieba.more;

import android.view.View;
/* loaded from: classes.dex */
class s implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AppsActivity f1503a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(AppsActivity appsActivity) {
        this.f1503a = appsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1503a.finish();
    }
}
