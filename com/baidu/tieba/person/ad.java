package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MyPostActivity f2167a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(MyPostActivity myPostActivity) {
        this.f2167a = myPostActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2167a.c();
    }
}
