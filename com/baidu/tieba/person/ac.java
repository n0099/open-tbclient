package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class ac implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MyPostActivity f2208a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(MyPostActivity myPostActivity) {
        this.f2208a = myPostActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2208a.finish();
    }
}
