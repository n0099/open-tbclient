package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
final class cp implements View.OnClickListener {
    final /* synthetic */ cm a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(cm cmVar) {
        this.a = cmVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        bj bjVar;
        bjVar = this.a.m;
        bjVar.e();
        this.a.c.a(false, true, 2);
    }
}
