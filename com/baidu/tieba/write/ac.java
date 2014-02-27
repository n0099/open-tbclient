package com.baidu.tieba.write;

import android.view.View;
/* loaded from: classes.dex */
final class ac implements View.OnClickListener {
    final /* synthetic */ ab a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.a = abVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        aa aaVar;
        aa aaVar2;
        aaVar = this.a.a.d;
        if (aaVar != null) {
            aaVar2 = this.a.a.d;
            aaVar2.a();
        }
    }
}
