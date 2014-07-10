package com.baidu.tieba.person;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class bp implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            com.baidu.tbadk.core.util.bj.a(this.a);
        } else if (i == 1) {
            com.baidu.tbadk.core.util.bj.c(this.a);
        }
    }
}
