package com.baidu.tieba.pb;

import android.app.Dialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bt f2084a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(bt btVar) {
        this.f2084a = btVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        dialog = this.f2084a.ac;
        dialog.dismiss();
    }
}
