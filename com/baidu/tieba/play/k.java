package com.baidu.tieba.play;

import com.baidu.tieba.play.t;
/* loaded from: classes.dex */
class k implements t.a {
    final /* synthetic */ c eIS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(c cVar) {
        this.eIS = cVar;
    }

    @Override // com.baidu.tieba.play.t.a
    public void onCompletion(t tVar) {
        t.a aVar;
        t.a aVar2;
        this.eIS.eIy = false;
        this.eIS.dnr = 0;
        if (this.eIS.cyE) {
            this.eIS.aWb();
            this.eIS.aWm();
            this.eIS.axO();
        } else {
            this.eIS.akW();
        }
        aVar = this.eIS.eIv;
        if (aVar != null) {
            aVar2 = this.eIS.eIv;
            aVar2.onCompletion(tVar);
        }
    }
}
