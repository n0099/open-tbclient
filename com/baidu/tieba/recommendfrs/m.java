package com.baidu.tieba.recommendfrs;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ f dXY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(f fVar) {
        this.dXY = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        r rVar2;
        rVar = this.dXY.dXT;
        if (rVar != null) {
            rVar2 = this.dXY.dXT;
            rVar2.update();
        }
    }
}
