package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonListActivity f1589a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(PersonListActivity personListActivity) {
        this.f1589a = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1589a.finish();
    }
}
