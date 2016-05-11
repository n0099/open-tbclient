package com.baidu.tieba.recommendfrs;

import com.baidu.tbadk.core.view.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements t.b {
    final /* synthetic */ f dXY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar) {
        this.dXY = fVar;
    }

    @Override // com.baidu.tbadk.core.view.t.b
    public void aG(boolean z) {
        r rVar;
        rVar = this.dXY.dXT;
        rVar.update();
    }
}
