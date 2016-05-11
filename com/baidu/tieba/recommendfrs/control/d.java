package com.baidu.tieba.recommendfrs.control;

import com.baidu.tieba.recommendfrs.indicator.ScrollFragmentTabHost;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.recommendfrs.b {
    final /* synthetic */ a dYW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.dYW = aVar;
    }

    @Override // com.baidu.tieba.recommendfrs.b
    public void b(int i, long j, long j2) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        com.baidu.tieba.recommendfrs.control.a.m mVar;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        scrollFragmentTabHost = this.dYW.dYN;
        if (scrollFragmentTabHost != null) {
            mVar = this.dYW.dYO;
            scrollFragmentTabHost2 = this.dYW.dYN;
            mVar.a(i, j, scrollFragmentTabHost2.bX(j), j2);
        }
    }

    @Override // com.baidu.tieba.recommendfrs.b
    public void bP(long j) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        com.baidu.tieba.recommendfrs.control.a.m mVar;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        scrollFragmentTabHost = this.dYW.dYN;
        if (scrollFragmentTabHost != null) {
            mVar = this.dYW.dYO;
            scrollFragmentTabHost2 = this.dYW.dYN;
            mVar.w(j, scrollFragmentTabHost2.bX(j));
        }
    }
}
