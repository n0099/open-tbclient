package com.baidu.tieba.person;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bv implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonInfoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(PersonInfoActivity personInfoActivity) {
        this.a = personInfoActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.model.av avVar;
        com.baidu.tieba.model.e eVar;
        com.baidu.tieba.model.e eVar2;
        com.baidu.tieba.model.e eVar3;
        avVar = this.a.mModel;
        int a = com.baidu.adp.lib.f.b.a(avVar.e(), -1);
        if (a > 0) {
            eVar = this.a.mBlackListModel;
            if (eVar.a() == 1) {
                eVar3 = this.a.mBlackListModel;
                eVar3.b(a);
                return;
            }
            eVar2 = this.a.mBlackListModel;
            eVar2.a(a);
        }
    }
}
