package com.baidu.tieba.pb;

import android.app.Dialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bo f1523a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(bo boVar) {
        this.f1523a = boVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        dialog = this.f1523a.T;
        dialog.dismiss();
    }
}
