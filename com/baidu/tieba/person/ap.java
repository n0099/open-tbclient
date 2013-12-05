package com.baidu.tieba.person;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class ap implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonChangeActivity f2314a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(PersonChangeActivity personChangeActivity) {
        this.f2314a = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            com.baidu.tieba.write.bd.a(this.f2314a);
        } else if (i == 1) {
            com.baidu.tieba.write.bd.c(this.f2314a);
        }
    }
}
