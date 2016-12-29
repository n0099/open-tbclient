package com.baidu.tieba.play;

import android.view.View;
import com.baidu.tieba.play.t;
/* loaded from: classes.dex */
class l implements t.b {
    final /* synthetic */ c eIS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(c cVar) {
        this.eIS = cVar;
    }

    @Override // com.baidu.tieba.play.t.b
    public boolean onError(t tVar, int i, int i2) {
        View view;
        View view2;
        View view3;
        t.b bVar;
        t.b bVar2;
        view = this.eIS.aOe;
        view.setVisibility(0);
        view2 = this.eIS.bKv;
        view2.setVisibility(8);
        view3 = this.eIS.aRZ;
        view3.setVisibility(8);
        bVar = this.eIS.eIw;
        if (bVar != null) {
            bVar2 = this.eIS.eIw;
            bVar2.onError(tVar, i, i2);
            return true;
        }
        return true;
    }
}
