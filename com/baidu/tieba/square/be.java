package com.baidu.tieba.square;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class be implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bd f2399a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(bd bdVar) {
        this.f2399a = bdVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
