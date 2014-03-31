package com.baidu.tieba.signall;

import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d extends com.baidu.adp.framework.c.b {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c cVar, int i) {
        super(1003001);
        this.a = cVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(HttpResponsedMessage httpResponsedMessage) {
        e eVar;
        e eVar2;
        e eVar3;
        a aVar;
        HttpResponsedMessage httpResponsedMessage2 = httpResponsedMessage;
        if (httpResponsedMessage2 == null || httpResponsedMessage2.g() != 1003001) {
            return;
        }
        int e = httpResponsedMessage2.e();
        if (httpResponsedMessage2.c() && e == 0) {
            this.a.a = ((GetForumResponsed) httpResponsedMessage2).a;
            eVar2 = this.a.b;
            if (eVar2 != null) {
                eVar3 = this.a.b;
                aVar = this.a.a;
                eVar3.a(aVar);
            }
        } else {
            String f = httpResponsedMessage2.f();
            eVar = this.a.b;
            eVar.a(f);
        }
        this.a.c = null;
    }
}
