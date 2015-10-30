package com.baidu.tieba.recommendfrs.indicator;

import com.baidu.tieba.recommendfrs.indicator.h;
/* loaded from: classes.dex */
class d implements h.a {
    final /* synthetic */ ScrollFragmentTabHost cJj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cJj = scrollFragmentTabHost;
    }

    @Override // com.baidu.tieba.recommendfrs.indicator.h.a
    public void aqw() {
        e eVar;
        h hVar;
        h hVar2;
        e eVar2;
        eVar = this.cJj.cJd;
        if (eVar != null) {
            eVar2 = this.cJj.cJd;
            eVar2.aqy();
        }
        hVar = this.cJj.cJg;
        if (hVar != null) {
            hVar2 = this.cJj.cJg;
            hVar2.a((h.a) null);
            this.cJj.cJg = null;
        }
    }
}
