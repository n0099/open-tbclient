package com.baidu.tieba.recommendfrs.indicator;

import com.baidu.tieba.recommendfrs.indicator.l;
/* loaded from: classes.dex */
class h implements l.a {
    final /* synthetic */ ScrollFragmentTabHost dXs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.dXs = scrollFragmentTabHost;
    }

    @Override // com.baidu.tieba.recommendfrs.indicator.l.a
    public void aok() {
        i iVar;
        l lVar;
        l lVar2;
        i iVar2;
        iVar = this.dXs.dXk;
        if (iVar != null) {
            iVar2 = this.dXs.dXk;
            iVar2.aom();
        }
        lVar = this.dXs.dXn;
        if (lVar != null) {
            lVar2 = this.dXs.dXn;
            lVar2.a((l.a) null);
            this.dXs.dXo = true;
            this.dXs.dXn = null;
        }
    }
}
