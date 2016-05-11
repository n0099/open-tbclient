package com.baidu.tieba.recommendfrs.indicator;

import com.baidu.tieba.recommendfrs.indicator.m;
/* loaded from: classes.dex */
class h implements m.a {
    final /* synthetic */ ScrollFragmentTabHost eaC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.eaC = scrollFragmentTabHost;
    }

    @Override // com.baidu.tieba.recommendfrs.indicator.m.a
    public void aon() {
        j jVar;
        m mVar;
        m mVar2;
        j jVar2;
        jVar = this.eaC.eat;
        if (jVar != null) {
            jVar2 = this.eaC.eat;
            jVar2.aop();
        }
        mVar = this.eaC.eaw;
        if (mVar != null) {
            mVar2 = this.eaC.eaw;
            mVar2.a((m.a) null);
            this.eaC.eax = true;
            this.eaC.eaw = null;
        }
    }
}
