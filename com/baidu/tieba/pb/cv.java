package com.baidu.tieba.pb;

import android.app.Dialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cv implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cr f2218a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cv(cr crVar) {
        this.f2218a = crVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        dialog = this.f2218a.I;
        dialog.dismiss();
    }
}
