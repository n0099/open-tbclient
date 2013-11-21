package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class bc implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2070a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(NewPbActivity newPbActivity) {
        this.f2070a = newPbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        cr crVar;
        cr crVar2;
        NewPbActivity newPbActivity = this.f2070a;
        crVar = this.f2070a.y;
        newPbActivity.z = crVar.ae();
        crVar2 = this.f2070a.y;
        crVar2.i();
        if (i == 0) {
            com.baidu.tieba.write.bd.a(this.f2070a);
        } else if (i == 1) {
            com.baidu.tieba.write.bd.c(this.f2070a);
        }
    }
}
