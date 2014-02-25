package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cu implements com.baidu.tieba.view.dialog.f {
    final /* synthetic */ cm a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cu(cm cmVar) {
        this.a = cmVar;
    }

    @Override // com.baidu.tieba.view.dialog.f
    public void a(com.baidu.tieba.view.dialog.d dVar, int i, View view) {
        if (i == 0) {
            this.a.l();
        }
        dVar.c();
    }
}
