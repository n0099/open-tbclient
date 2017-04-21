package com.baidu.tieba.play;

import android.view.View;
import com.baidu.tieba.play.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements v.b {
    final /* synthetic */ c eWq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(c cVar) {
        this.eWq = cVar;
    }

    @Override // com.baidu.tieba.play.v.b
    public boolean onError(v vVar, int i, int i2) {
        View view;
        View view2;
        View view3;
        v.b bVar;
        v.b bVar2;
        view = this.eWq.aTl;
        view.setVisibility(0);
        view2 = this.eWq.cKY;
        view2.setVisibility(8);
        view3 = this.eWq.eWd;
        view3.setVisibility(8);
        this.eWq.akS = 4;
        this.eWq.aTd.setRecoveryState(4);
        bVar = this.eWq.eWk;
        if (bVar != null) {
            bVar2 = this.eWq.eWk;
            bVar2.onError(vVar, i, i2);
            return true;
        }
        return true;
    }
}
