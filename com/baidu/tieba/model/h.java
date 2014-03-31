package com.baidu.tieba.model;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.message.ResponseSetBubbleMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h extends com.baidu.adp.framework.c.b {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(f fVar, int i) {
        super(1006001);
        this.a = fVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(HttpResponsedMessage httpResponsedMessage) {
        j jVar;
        j jVar2;
        j jVar3;
        HttpResponsedMessage httpResponsedMessage2 = httpResponsedMessage;
        if (httpResponsedMessage2 == null || httpResponsedMessage2.g() != 1006001) {
            return;
        }
        jVar = this.a.b;
        if (jVar != null) {
            int d = httpResponsedMessage2.d();
            int e = httpResponsedMessage2.e();
            if (d != 200 || e != 0 || !(httpResponsedMessage2 instanceof ResponseSetBubbleMessage)) {
                jVar2 = this.a.b;
                jVar2.b(null);
                return;
            }
            jVar3 = this.a.b;
            jVar3.a(((ResponseSetBubbleMessage) httpResponsedMessage2).i());
        }
    }
}
