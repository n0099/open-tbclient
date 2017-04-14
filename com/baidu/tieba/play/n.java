package com.baidu.tieba.play;

import android.view.View;
import com.baidu.tieba.play.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements v.b {
    final /* synthetic */ c eUa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(c cVar) {
        this.eUa = cVar;
    }

    @Override // com.baidu.tieba.play.v.b
    public boolean onError(v vVar, int i, int i2) {
        View view;
        View view2;
        View view3;
        v.b bVar;
        v.b bVar2;
        view = this.eUa.aTj;
        view.setVisibility(0);
        view2 = this.eUa.cIH;
        view2.setVisibility(8);
        view3 = this.eUa.eTN;
        view3.setVisibility(8);
        this.eUa.akR = 4;
        this.eUa.aTb.setRecoveryState(4);
        bVar = this.eUa.eTU;
        if (bVar != null) {
            bVar2 = this.eUa.eTU;
            bVar2.onError(vVar, i, i2);
            return true;
        }
        return true;
    }
}
