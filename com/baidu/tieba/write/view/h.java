package com.baidu.tieba.write.view;

import android.view.View;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    final /* synthetic */ f cAZ;
    private final f cBa;
    private final i cBb;

    public h(f fVar, f fVar2, i iVar) {
        this.cAZ = fVar;
        this.cBa = fVar2;
        this.cBb = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cBb != null) {
            this.cBb.a(this.cBa);
        }
    }
}
