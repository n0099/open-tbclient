package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class ab implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MyPostActivity f1559a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(MyPostActivity myPostActivity) {
        this.f1559a = myPostActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1559a.finish();
    }
}
