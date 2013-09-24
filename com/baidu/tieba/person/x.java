package com.baidu.tieba.person;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class x implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditMarkActivity f1738a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(EditMarkActivity editMarkActivity) {
        this.f1738a = editMarkActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        y yVar;
        com.baidu.tieba.model.h hVar;
        com.baidu.tieba.model.h hVar2;
        yVar = this.f1738a.b;
        hVar = this.f1738a.f1640a;
        yVar.a(hVar.a());
        hVar2 = this.f1738a.f1640a;
        hVar2.a((Boolean) true);
    }
}
