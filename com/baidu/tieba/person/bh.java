package com.baidu.tieba.person;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonInfoActivity f2333a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(PersonInfoActivity personInfoActivity) {
        this.f2333a = personInfoActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            this.f2333a.I();
        } else if (i == 1) {
            com.baidu.tieba.write.bd.a(this.f2333a.i());
        } else if (i == 2) {
            com.baidu.tieba.write.bd.c(this.f2333a.i());
        }
    }
}
