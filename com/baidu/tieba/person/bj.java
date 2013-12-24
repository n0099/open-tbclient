package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements com.baidu.tieba.view.dialog.c {
    final /* synthetic */ PersonInfoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(PersonInfoActivity personInfoActivity) {
        this.a = personInfoActivity;
    }

    @Override // com.baidu.tieba.view.dialog.c
    public void a(com.baidu.tieba.view.dialog.a aVar, int i, View view) {
        if (i == 0) {
            this.a.I();
        }
        aVar.c();
    }
}
