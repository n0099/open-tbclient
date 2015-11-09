package com.baidu.tieba.recommendfrs.indicator;

import com.baidu.tieba.recommendfrs.indicator.h;
/* loaded from: classes.dex */
class d implements h.a {
    final /* synthetic */ ScrollFragmentTabHost cKF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cKF = scrollFragmentTabHost;
    }

    @Override // com.baidu.tieba.recommendfrs.indicator.h.a
    public void arc() {
        e eVar;
        h hVar;
        h hVar2;
        e eVar2;
        eVar = this.cKF.cKz;
        if (eVar != null) {
            eVar2 = this.cKF.cKz;
            eVar2.are();
        }
        hVar = this.cKF.cKC;
        if (hVar != null) {
            hVar2 = this.cKF.cKC;
            hVar2.a((h.a) null);
            this.cKF.cKC = null;
        }
    }
}
