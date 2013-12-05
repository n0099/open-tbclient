package com.baidu.tieba.person;

import android.app.Dialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aa f2300a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.f2300a = aaVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Dialog dialog;
        dialog = this.f2300a.j;
        dialog.dismiss();
    }
}
