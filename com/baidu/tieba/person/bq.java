package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonListActivity f1636a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(PersonListActivity personListActivity) {
        this.f1636a = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1636a.a(true);
    }
}
