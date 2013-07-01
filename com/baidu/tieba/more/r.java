package com.baidu.tieba.more;

import android.view.View;
/* loaded from: classes.dex */
class r implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AppsActivity f1106a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(AppsActivity appsActivity) {
        this.f1106a = appsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1106a.finish();
    }
}
