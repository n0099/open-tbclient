package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class ay implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2061a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(NewPbActivity newPbActivity) {
        this.f2061a = newPbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        bt btVar;
        bt btVar2;
        NewPbActivity newPbActivity = this.f2061a;
        btVar = this.f2061a.u;
        newPbActivity.v = btVar.ah();
        btVar2 = this.f2061a.u;
        btVar2.l();
        if (i == 0) {
            com.baidu.tieba.write.bg.a(this.f2061a);
        } else if (i == 1) {
            com.baidu.tieba.write.bg.b(this.f2061a);
        }
    }
}
