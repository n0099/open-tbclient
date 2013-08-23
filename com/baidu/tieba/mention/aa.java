package com.baidu.tieba.mention;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class aa implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ y f1323a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y yVar) {
        this.f1323a = yVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
