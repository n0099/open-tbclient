package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class bn implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonListActivity f1633a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(PersonListActivity personListActivity) {
        this.f1633a = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1633a.finish();
    }
}
