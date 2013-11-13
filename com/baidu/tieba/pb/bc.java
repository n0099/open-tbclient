package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class bc implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2087a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(NewPbActivity newPbActivity) {
        this.f2087a = newPbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        cp cpVar;
        cp cpVar2;
        NewPbActivity newPbActivity = this.f2087a;
        cpVar = this.f2087a.y;
        newPbActivity.z = cpVar.ae();
        cpVar2 = this.f2087a.y;
        cpVar2.i();
        if (i == 0) {
            com.baidu.tieba.write.bc.a(this.f2087a);
        } else if (i == 1) {
            com.baidu.tieba.write.bc.c(this.f2087a);
        }
    }
}
