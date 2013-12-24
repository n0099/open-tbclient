package com.baidu.tieba.person;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonInfoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(PersonInfoActivity personInfoActivity) {
        this.a = personInfoActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.model.bx bxVar;
        com.baidu.tieba.im.model.b bVar;
        com.baidu.tieba.im.model.b bVar2;
        com.baidu.tieba.im.model.b bVar3;
        bxVar = this.a.e;
        int a = com.baidu.adp.lib.f.b.a(bxVar.b(), -1);
        if (a > 0) {
            bVar = this.a.f;
            if (bVar.b() == 1) {
                bVar3 = this.a.f;
                bVar3.b(a);
                return;
            }
            bVar2 = this.a.f;
            bVar2.a(a);
        }
    }
}
