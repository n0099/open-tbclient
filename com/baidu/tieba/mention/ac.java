package com.baidu.tieba.mention;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class ac implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aa f1852a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(aa aaVar) {
        this.f1852a = aaVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
