package com.baidu.tieba.pb;

import android.app.Dialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class da implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bt f2115a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public da(bt btVar) {
        this.f2115a = btVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        dialog = this.f2115a.X;
        dialog.dismiss();
    }
}
