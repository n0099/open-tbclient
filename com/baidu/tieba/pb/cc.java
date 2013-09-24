package com.baidu.tieba.pb;

import android.app.Dialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ br f1574a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(br brVar) {
        this.f1574a = brVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        dialog = this.f1574a.am;
        dialog.dismiss();
    }
}
