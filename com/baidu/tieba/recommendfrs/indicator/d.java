package com.baidu.tieba.recommendfrs.indicator;

import com.baidu.tieba.recommendfrs.indicator.h;
/* loaded from: classes.dex */
class d implements h.a {
    final /* synthetic */ ScrollFragmentTabHost cIK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cIK = scrollFragmentTabHost;
    }

    @Override // com.baidu.tieba.recommendfrs.indicator.h.a
    public void aqu() {
        e eVar;
        h hVar;
        h hVar2;
        e eVar2;
        eVar = this.cIK.cIE;
        if (eVar != null) {
            eVar2 = this.cIK.cIE;
            eVar2.aqw();
        }
        hVar = this.cIK.cIH;
        if (hVar != null) {
            hVar2 = this.cIK.cIH;
            hVar2.a((h.a) null);
            this.cIK.cIH = null;
        }
    }
}
