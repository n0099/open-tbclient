package com.baidu.tieba.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnClickListener {
    final /* synthetic */ ac a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar) {
        this.a = acVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aa aaVar;
        ab abVar;
        aa aaVar2;
        ab abVar2;
        aaVar = this.a.a;
        abVar = aaVar.d;
        if (abVar != null) {
            aaVar2 = this.a.a;
            abVar2 = aaVar2.d;
            abVar2.a();
        }
    }
}
