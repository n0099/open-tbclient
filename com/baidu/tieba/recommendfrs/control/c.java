package com.baidu.tieba.recommendfrs.control;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tieba.recommendfrs.a {
    final /* synthetic */ a diB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.diB = aVar;
    }

    @Override // com.baidu.tieba.recommendfrs.a
    public void b(int i, long j, long j2) {
        com.baidu.tieba.recommendfrs.control.a.b bVar;
        bVar = this.diB.diw;
        bVar.c(i, j, j2);
    }

    @Override // com.baidu.tieba.recommendfrs.a
    public void bv(long j) {
        com.baidu.tieba.recommendfrs.control.a.b bVar;
        bVar = this.diB.diw;
        bVar.bx(j);
    }
}
