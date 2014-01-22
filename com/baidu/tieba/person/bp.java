package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp implements com.baidu.tieba.view.dialog.f {
    final /* synthetic */ PersonInfoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(PersonInfoActivity personInfoActivity) {
        this.a = personInfoActivity;
    }

    @Override // com.baidu.tieba.view.dialog.f
    public void a(com.baidu.tieba.view.dialog.d dVar, int i, View view) {
        if (i == 0) {
            this.a.J();
        }
        dVar.c();
    }
}
