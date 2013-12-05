package com.baidu.tieba.im.validate;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ n f1906a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.f1906a = nVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ValidateActivity validateActivity;
        validateActivity = this.f1906a.d;
        validateActivity.finish();
    }
}
