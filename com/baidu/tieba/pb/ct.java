package com.baidu.tieba.pb;

import android.app.Dialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ct implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cp f2125a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(cp cpVar) {
        this.f2125a = cpVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        dialog = this.f2125a.I;
        dialog.dismiss();
    }
}
