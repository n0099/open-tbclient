package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
final class bu implements View.OnClickListener {
    final /* synthetic */ bn a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(bn bnVar) {
        this.a = bnVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ak akVar;
        akVar = this.a.l;
        akVar.e();
        this.a.c.a(false, true, 2);
    }
}
