package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class at implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1539a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(NewPbActivity newPbActivity) {
        this.f1539a = newPbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        br brVar;
        br brVar2;
        NewPbActivity newPbActivity = this.f1539a;
        brVar = this.f1539a.t;
        newPbActivity.u = brVar.ah();
        brVar2 = this.f1539a.t;
        brVar2.l();
        if (i == 0) {
            com.baidu.tieba.write.bf.a(this.f1539a);
        } else if (i == 1) {
            com.baidu.tieba.write.bf.b(this.f1539a);
        }
    }
}
