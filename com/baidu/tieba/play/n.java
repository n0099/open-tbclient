package com.baidu.tieba.play;

import android.view.View;
import com.baidu.tieba.play.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements v.b {
    final /* synthetic */ c eWb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(c cVar) {
        this.eWb = cVar;
    }

    @Override // com.baidu.tieba.play.v.b
    public boolean onError(v vVar, int i, int i2) {
        View view;
        View view2;
        View view3;
        v.b bVar;
        v.b bVar2;
        view = this.eWb.aSU;
        view.setVisibility(0);
        view2 = this.eWb.bXW;
        view2.setVisibility(8);
        view3 = this.eWb.eVO;
        view3.setVisibility(8);
        this.eWb.akD = 4;
        this.eWb.aSL.setRecoveryState(4);
        bVar = this.eWb.eVV;
        if (bVar != null) {
            bVar2 = this.eWb.eVV;
            bVar2.onError(vVar, i, i2);
            return true;
        }
        return true;
    }
}
