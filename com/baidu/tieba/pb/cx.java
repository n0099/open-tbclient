package com.baidu.tieba.pb;

import android.app.Dialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cx implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cr f2220a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cx(cr crVar) {
        this.f2220a = crVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        dialog = this.f2220a.X;
        dialog.dismiss();
    }
}
