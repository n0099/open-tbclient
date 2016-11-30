package com.baidu.tieba.play;

import com.baidu.tieba.play.t;
/* loaded from: classes.dex */
class k implements t.a {
    final /* synthetic */ c ffA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(c cVar) {
        this.ffA = cVar;
    }

    @Override // com.baidu.tieba.play.t.a
    public void onCompletion(t tVar) {
        t.a aVar;
        t.a aVar2;
        this.ffA.feZ = false;
        this.ffA.ffd = 0;
        if (this.ffA.cTv) {
            this.ffA.bcq();
            this.ffA.bcB();
            this.ffA.bcG();
        } else {
            this.ffA.aqu();
        }
        aVar = this.ffA.feW;
        if (aVar != null) {
            aVar2 = this.ffA.feW;
            aVar2.onCompletion(tVar);
        }
    }
}
