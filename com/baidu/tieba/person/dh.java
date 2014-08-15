package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dh implements View.OnClickListener {
    final /* synthetic */ ct a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dh(ct ctVar) {
        this.a = ctVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bd bdVar;
        bdVar = this.a.l;
        bdVar.d();
        this.a.o();
    }
}
