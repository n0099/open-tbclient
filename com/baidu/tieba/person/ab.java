package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class ab implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MyPostActivity f1597a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(MyPostActivity myPostActivity) {
        this.f1597a = myPostActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1597a.finish();
    }
}
