package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonListActivity f2241a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(PersonListActivity personListActivity) {
        this.f2241a = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2241a.a(true);
    }
}
