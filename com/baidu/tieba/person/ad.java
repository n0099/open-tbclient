package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class ad implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MyPostActivity f2194a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(MyPostActivity myPostActivity) {
        this.f2194a = myPostActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2194a.c();
    }
}
