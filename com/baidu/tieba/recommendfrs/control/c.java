package com.baidu.tieba.recommendfrs.control;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tieba.recommendfrs.a {
    final /* synthetic */ a cBa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.cBa = aVar;
    }

    @Override // com.baidu.tieba.recommendfrs.a
    public void b(int i, String str, int i2) {
        com.baidu.tieba.recommendfrs.control.a.b bVar;
        bVar = this.cBa.cAV;
        bVar.c(i, str, i2);
    }

    @Override // com.baidu.tieba.recommendfrs.a
    public void ku(String str) {
        com.baidu.tieba.recommendfrs.control.a.b bVar;
        bVar = this.cBa.cAV;
        bVar.kw(str);
    }
}
