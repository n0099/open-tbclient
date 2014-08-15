package com.baidu.tieba.person;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class g implements DialogInterface.OnClickListener {
    final /* synthetic */ EditMarkActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(EditMarkActivity editMarkActivity) {
        this.a = editMarkActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        h hVar;
        com.baidu.tieba.model.j jVar;
        com.baidu.tieba.model.j jVar2;
        hVar = this.a.b;
        jVar = this.a.a;
        hVar.a(jVar.a());
        jVar2 = this.a.a;
        jVar2.a((Boolean) true);
    }
}
