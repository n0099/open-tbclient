package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonListActivity f1592a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(PersonListActivity personListActivity) {
        this.f1592a = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1592a.a(true);
    }
}
