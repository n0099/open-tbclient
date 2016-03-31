package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.tieba.recommendfrs.control.a.g;
import com.baidu.tieba.recommendfrs.control.a.m;
import tbclient.Personalized.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements g.a {
    final /* synthetic */ m dWx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.dWx = mVar;
    }

    @Override // com.baidu.tieba.recommendfrs.control.a.g.a
    public void b(long j, DataRes dataRes, boolean z) {
        m.a aVar;
        m.a aVar2;
        aVar = this.dWx.dWt;
        if (aVar != null) {
            aVar2 = this.dWx.dWt;
            aVar2.a(j, dataRes, z);
        }
    }

    @Override // com.baidu.tieba.recommendfrs.control.a.g.a
    public void e(long j, int i, String str) {
        m.a aVar;
        m.a aVar2;
        aVar = this.dWx.dWt;
        if (aVar != null) {
            aVar2 = this.dWx.dWt;
            aVar2.a(j, str, i);
        }
    }
}
