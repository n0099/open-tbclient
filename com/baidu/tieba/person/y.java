package com.baidu.tieba.person;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class y implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditMarkActivity f1618a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(EditMarkActivity editMarkActivity) {
        this.f1618a = editMarkActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        z zVar;
        com.baidu.tieba.model.f fVar;
        com.baidu.tieba.model.f fVar2;
        zVar = this.f1618a.b;
        fVar = this.f1618a.f1552a;
        zVar.a(fVar.a());
        fVar2 = this.f1618a.f1552a;
        fVar2.f();
    }
}
