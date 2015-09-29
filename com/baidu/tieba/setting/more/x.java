package com.baidu.tieba.setting.more;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {
    final /* synthetic */ v cNs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(v vVar) {
        this.cNs = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        rVar = this.cNs.cNb;
        rVar.kx(12);
    }
}
