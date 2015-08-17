package com.baidu.tieba.recommendfrs.indicator;

import com.baidu.tieba.recommendfrs.indicator.h;
/* loaded from: classes.dex */
class d implements h.a {
    final /* synthetic */ ScrollFragmentTabHost ctr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.ctr = scrollFragmentTabHost;
    }

    @Override // com.baidu.tieba.recommendfrs.indicator.h.a
    public void ajW() {
        e eVar;
        h hVar;
        h hVar2;
        e eVar2;
        eVar = this.ctr.ctl;
        if (eVar != null) {
            eVar2 = this.ctr.ctl;
            eVar2.ajY();
        }
        hVar = this.ctr.cto;
        if (hVar != null) {
            hVar2 = this.ctr.cto;
            hVar2.a((h.a) null);
            this.ctr.cto = null;
        }
    }
}
