package com.baidu.tieba.write.view;

import android.view.View;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    final /* synthetic */ f cBa;
    private final f cBb;
    private final i cBc;

    public h(f fVar, f fVar2, i iVar) {
        this.cBa = fVar;
        this.cBb = fVar2;
        this.cBc = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cBc != null) {
            this.cBc.a(this.cBb);
        }
    }
}
