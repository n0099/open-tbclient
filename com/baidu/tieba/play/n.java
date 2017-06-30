package com.baidu.tieba.play;

import android.view.View;
import com.baidu.tieba.play.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements v.b {
    final /* synthetic */ c flr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(c cVar) {
        this.flr = cVar;
    }

    @Override // com.baidu.tieba.play.v.b
    public boolean onError(v vVar, int i, int i2) {
        View view;
        View view2;
        View view3;
        v.b bVar;
        v.b bVar2;
        view = this.flr.bDE;
        view.setVisibility(0);
        view2 = this.flr.cSw;
        view2.setVisibility(8);
        view3 = this.flr.fld;
        view3.setVisibility(8);
        this.flr.akS = 4;
        this.flr.bDx.setRecoveryState(4);
        bVar = this.flr.flk;
        if (bVar != null) {
            bVar2 = this.flr.flk;
            bVar2.onError(vVar, i, i2);
            return true;
        }
        return true;
    }
}
