package com.baidu.tieba.more;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AppsActivity f2012a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(AppsActivity appsActivity) {
        this.f2012a = appsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2012a.b();
    }
}
