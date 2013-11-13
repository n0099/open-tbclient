package com.baidu.tieba.more;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AppsActivity f2013a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(AppsActivity appsActivity) {
        this.f2013a = appsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2013a.finish();
    }
}
