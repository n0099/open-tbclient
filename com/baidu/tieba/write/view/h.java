package com.baidu.tieba.write.view;

import android.view.View;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    final /* synthetic */ f cwI;
    private final f cwJ;
    private final i cwK;

    public h(f fVar, f fVar2, i iVar) {
        this.cwI = fVar;
        this.cwJ = fVar2;
        this.cwK = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cwK != null) {
            this.cwK.onClick(this.cwJ);
        }
    }
}
