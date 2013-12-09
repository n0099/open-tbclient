package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MyPostActivity f2302a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(MyPostActivity myPostActivity) {
        this.f2302a = myPostActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2302a.finish();
    }
}
