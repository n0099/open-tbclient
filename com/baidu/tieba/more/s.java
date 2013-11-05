package com.baidu.tieba.more;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AppsActivity f2019a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(AppsActivity appsActivity) {
        this.f2019a = appsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2019a.c();
    }
}
