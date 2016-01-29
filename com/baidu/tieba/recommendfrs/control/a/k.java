package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.tieba.recommendfrs.control.a.g;
import com.baidu.tieba.recommendfrs.control.a.j;
import tbclient.Personalized.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements g.a {
    final /* synthetic */ j dEz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.dEz = jVar;
    }

    @Override // com.baidu.tieba.recommendfrs.control.a.g.a
    public void b(long j, DataRes dataRes, boolean z) {
        j.a aVar;
        j.a aVar2;
        aVar = this.dEz.dEv;
        if (aVar != null) {
            aVar2 = this.dEz.dEv;
            aVar2.a(j, dataRes, z);
        }
    }

    @Override // com.baidu.tieba.recommendfrs.control.a.g.a
    public void b(long j, int i, String str) {
        j.a aVar;
        j.a aVar2;
        aVar = this.dEz.dEv;
        if (aVar != null) {
            aVar2 = this.dEz.dEv;
            aVar2.a(j, str, i);
        }
    }
}
