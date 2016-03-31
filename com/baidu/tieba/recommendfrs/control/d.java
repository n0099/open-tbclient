package com.baidu.tieba.recommendfrs.control;

import com.baidu.tieba.recommendfrs.control.a.m;
import com.baidu.tieba.recommendfrs.indicator.ScrollFragmentTabHost;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.recommendfrs.b {
    final /* synthetic */ a dVV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.dVV = aVar;
    }

    @Override // com.baidu.tieba.recommendfrs.b
    public void b(int i, long j, long j2) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        m mVar;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        scrollFragmentTabHost = this.dVV.dVM;
        if (scrollFragmentTabHost != null) {
            mVar = this.dVV.dVN;
            scrollFragmentTabHost2 = this.dVV.dVM;
            mVar.a(i, j, scrollFragmentTabHost2.bX(j), j2);
        }
    }

    @Override // com.baidu.tieba.recommendfrs.b
    public void bP(long j) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        m mVar;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        scrollFragmentTabHost = this.dVV.dVM;
        if (scrollFragmentTabHost != null) {
            mVar = this.dVV.dVN;
            scrollFragmentTabHost2 = this.dVV.dVM;
            mVar.v(j, scrollFragmentTabHost2.bX(j));
        }
    }
}
