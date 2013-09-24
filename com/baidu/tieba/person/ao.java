package com.baidu.tieba.person;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class ao implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonChangeActivity f1660a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(PersonChangeActivity personChangeActivity) {
        this.f1660a = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            com.baidu.tieba.write.bf.a(this.f1660a);
        } else if (i == 1) {
            com.baidu.tieba.write.bf.b(this.f1660a);
        }
    }
}
