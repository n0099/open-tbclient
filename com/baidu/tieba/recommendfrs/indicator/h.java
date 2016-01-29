package com.baidu.tieba.recommendfrs.indicator;

import com.baidu.tieba.recommendfrs.indicator.l;
/* loaded from: classes.dex */
class h implements l.a {
    final /* synthetic */ ScrollFragmentTabHost dFt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.dFt = scrollFragmentTabHost;
    }

    @Override // com.baidu.tieba.recommendfrs.indicator.l.a
    public void aFO() {
        i iVar;
        l lVar;
        l lVar2;
        i iVar2;
        iVar = this.dFt.dFl;
        if (iVar != null) {
            iVar2 = this.dFt.dFl;
            iVar2.aFQ();
        }
        lVar = this.dFt.dFo;
        if (lVar != null) {
            lVar2 = this.dFt.dFo;
            lVar2.a((l.a) null);
            this.dFt.dFp = true;
            this.dFt.dFo = null;
        }
    }
}
