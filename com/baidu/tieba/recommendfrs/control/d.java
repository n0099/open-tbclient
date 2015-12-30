package com.baidu.tieba.recommendfrs.control;

import com.baidu.tieba.recommendfrs.control.a.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.recommendfrs.a {
    final /* synthetic */ a doN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.doN = aVar;
    }

    @Override // com.baidu.tieba.recommendfrs.a
    public void b(int i, long j, long j2) {
        j jVar;
        jVar = this.doN.doH;
        jVar.c(i, j, j2);
    }

    @Override // com.baidu.tieba.recommendfrs.a
    public void bC(long j) {
        j jVar;
        jVar = this.doN.doH;
        jVar.bG(j);
    }
}
