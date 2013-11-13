package com.baidu.tieba.person;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonChangeActivity f2221a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(PersonChangeActivity personChangeActivity) {
        this.f2221a = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            com.baidu.tieba.write.bc.a(this.f2221a);
        } else if (i == 1) {
            com.baidu.tieba.write.bc.c(this.f2221a);
        }
    }
}
