package com.baidu.tieba.pb;

import android.app.Dialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bn f1485a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(bn bnVar) {
        this.f1485a = bnVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        dialog = this.f1485a.R;
        dialog.dismiss();
    }
}
