package com.baidu.tieba.play;

import android.view.View;
import com.baidu.tieba.play.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements v.b {
    final /* synthetic */ c eSq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(c cVar) {
        this.eSq = cVar;
    }

    @Override // com.baidu.tieba.play.v.b
    public boolean onError(v vVar, int i, int i2) {
        View view;
        View view2;
        View view3;
        v.b bVar;
        v.b bVar2;
        view = this.eSq.aTG;
        view.setVisibility(0);
        view2 = this.eSq.cFb;
        view2.setVisibility(8);
        view3 = this.eSq.eSd;
        view3.setVisibility(8);
        this.eSq.akp = 4;
        this.eSq.aTy.setRecoveryState(4);
        bVar = this.eSq.eSk;
        if (bVar != null) {
            bVar2 = this.eSq.eSk;
            bVar2.onError(vVar, i, i2);
            return true;
        }
        return true;
    }
}
