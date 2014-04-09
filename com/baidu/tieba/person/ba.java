package com.baidu.tieba.person;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class ba implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            com.baidu.tbadk.core.util.az.a(this.a);
        } else if (i == 1) {
            com.baidu.tbadk.core.util.az.b(this.a);
        }
    }
}
