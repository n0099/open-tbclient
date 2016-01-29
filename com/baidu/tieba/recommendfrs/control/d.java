package com.baidu.tieba.recommendfrs.control;

import com.baidu.tieba.recommendfrs.indicator.ScrollFragmentTabHost;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.recommendfrs.b {
    final /* synthetic */ a dEd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.dEd = aVar;
    }

    @Override // com.baidu.tieba.recommendfrs.b
    public void b(int i, long j, long j2) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        com.baidu.tieba.recommendfrs.control.a.j jVar;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        scrollFragmentTabHost = this.dEd.dDV;
        if (scrollFragmentTabHost != null) {
            jVar = this.dEd.dDW;
            scrollFragmentTabHost2 = this.dEd.dDV;
            jVar.a(i, j, scrollFragmentTabHost2.bN(j), j2);
        }
    }

    @Override // com.baidu.tieba.recommendfrs.b
    public void bF(long j) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        com.baidu.tieba.recommendfrs.control.a.j jVar;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        scrollFragmentTabHost = this.dEd.dDV;
        if (scrollFragmentTabHost != null) {
            jVar = this.dEd.dDW;
            scrollFragmentTabHost2 = this.dEd.dDV;
            jVar.h(j, scrollFragmentTabHost2.bN(j));
        }
    }
}
