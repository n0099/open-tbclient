package com.baidu.tieba.person;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class bz implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            com.baidu.tieba.write.bz.a(this.a);
        } else if (i == 1) {
            com.baidu.tieba.write.bz.d(this.a);
        }
    }
}
