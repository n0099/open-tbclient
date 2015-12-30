package com.baidu.tieba.recommendfrs.indicator;

import com.baidu.tieba.recommendfrs.indicator.h;
/* loaded from: classes.dex */
class d implements h.a {
    final /* synthetic */ ScrollFragmentTabHost dpF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.dpF = scrollFragmentTabHost;
    }

    @Override // com.baidu.tieba.recommendfrs.indicator.h.a
    public void ayG() {
        e eVar;
        h hVar;
        h hVar2;
        e eVar2;
        eVar = this.dpF.dpy;
        if (eVar != null) {
            eVar2 = this.dpF.dpy;
            eVar2.ayI();
        }
        hVar = this.dpF.dpB;
        if (hVar != null) {
            hVar2 = this.dpF.dpB;
            hVar2.a((h.a) null);
            this.dpF.dpC = true;
            this.dpF.dpB = null;
        }
    }
}
