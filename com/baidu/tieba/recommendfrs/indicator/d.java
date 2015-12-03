package com.baidu.tieba.recommendfrs.indicator;

import com.baidu.tieba.recommendfrs.indicator.h;
/* loaded from: classes.dex */
class d implements h.a {
    final /* synthetic */ ScrollFragmentTabHost djb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.djb = scrollFragmentTabHost;
    }

    @Override // com.baidu.tieba.recommendfrs.indicator.h.a
    public void awA() {
        e eVar;
        h hVar;
        h hVar2;
        e eVar2;
        eVar = this.djb.diU;
        if (eVar != null) {
            eVar2 = this.djb.diU;
            eVar2.awC();
        }
        hVar = this.djb.diX;
        if (hVar != null) {
            hVar2 = this.djb.diX;
            hVar2.a((h.a) null);
            this.djb.diY = true;
            this.djb.diX = null;
        }
    }
}
