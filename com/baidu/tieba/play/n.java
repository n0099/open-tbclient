package com.baidu.tieba.play;

import android.view.View;
import com.baidu.tieba.play.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements v.b {
    final /* synthetic */ c eSu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(c cVar) {
        this.eSu = cVar;
    }

    @Override // com.baidu.tieba.play.v.b
    public boolean onError(v vVar, int i, int i2) {
        View view;
        View view2;
        View view3;
        v.b bVar;
        v.b bVar2;
        view = this.eSu.aNh;
        view.setVisibility(0);
        view2 = this.eSu.bQO;
        view2.setVisibility(8);
        view3 = this.eSu.eSk;
        view3.setVisibility(8);
        this.eSu.afl = 4;
        this.eSu.aMY.setRecoveryState(4);
        bVar = this.eSu.dvs;
        if (bVar != null) {
            bVar2 = this.eSu.dvs;
            bVar2.onError(vVar, i, i2);
            return true;
        }
        return true;
    }
}
