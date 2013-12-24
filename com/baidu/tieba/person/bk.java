package com.baidu.tieba.person;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonInfoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(PersonInfoActivity personInfoActivity) {
        this.a = personInfoActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            this.a.N();
        } else if (i == 1) {
            com.baidu.tieba.write.bd.a(this.a.i());
        } else if (i == 2) {
            com.baidu.tieba.write.bd.c(this.a.i());
        }
    }
}
