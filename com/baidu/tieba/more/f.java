package com.baidu.tieba.more;

import android.view.View;
/* loaded from: classes.dex */
class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccountActivity f1447a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AccountActivity accountActivity) {
        this.f1447a = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1447a.finish();
    }
}
