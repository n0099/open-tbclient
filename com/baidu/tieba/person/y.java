package com.baidu.tieba.person;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class y implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditMarkActivity f1377a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(EditMarkActivity editMarkActivity) {
        this.f1377a = editMarkActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        z zVar;
        com.baidu.tieba.model.f fVar;
        com.baidu.tieba.model.f fVar2;
        zVar = this.f1377a.b;
        fVar = this.f1377a.f1301a;
        zVar.a(fVar.a());
        fVar2 = this.f1377a.f1301a;
        fVar2.f();
    }
}
