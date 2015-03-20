package com.baidu.tieba.write.view;

import android.view.View;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    final /* synthetic */ f cws;
    private final f cwt;
    private final i cwu;

    public h(f fVar, f fVar2, i iVar) {
        this.cws = fVar;
        this.cwt = fVar2;
        this.cwu = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cwu != null) {
            this.cwu.onClick(this.cwt);
        }
    }
}
