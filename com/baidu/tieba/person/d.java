package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditBarActivity f1598a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(EditBarActivity editBarActivity) {
        this.f1598a = editBarActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1598a.finish();
    }
}
