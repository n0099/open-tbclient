package com.baidu.tieba.recommendfrs.indicator;

import com.baidu.tieba.recommendfrs.indicator.h;
/* loaded from: classes.dex */
class d implements h.a {
    final /* synthetic */ ScrollFragmentTabHost cBJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cBJ = scrollFragmentTabHost;
    }

    @Override // com.baidu.tieba.recommendfrs.indicator.h.a
    public void aoc() {
        e eVar;
        h hVar;
        h hVar2;
        e eVar2;
        eVar = this.cBJ.cBD;
        if (eVar != null) {
            eVar2 = this.cBJ.cBD;
            eVar2.aoe();
        }
        hVar = this.cBJ.cBG;
        if (hVar != null) {
            hVar2 = this.cBJ.cBG;
            hVar2.a((h.a) null);
            this.cBJ.cBG = null;
        }
    }
}
