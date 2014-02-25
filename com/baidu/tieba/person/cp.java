package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cp implements View.OnClickListener {
    final /* synthetic */ cm a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(cm cmVar) {
        this.a = cmVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bj bjVar;
        bjVar = this.a.m;
        bjVar.g();
        this.a.k();
    }
}
