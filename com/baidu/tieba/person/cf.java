package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
final class cf implements View.OnClickListener {
    final /* synthetic */ PersonListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(PersonListActivity personListActivity) {
        this.a = personListActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PersonListActivity.a(this.a, true);
    }
}
