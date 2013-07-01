package com.baidu.tieba.pb;

import android.app.Dialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bk f1238a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(bk bkVar) {
        this.f1238a = bkVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        dialog = this.f1238a.ag;
        dialog.dismiss();
    }
}
