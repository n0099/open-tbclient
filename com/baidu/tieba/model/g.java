package com.baidu.tieba.model;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.message.ResponseBubbleListMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g extends com.baidu.adp.framework.c.b {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(f fVar, int i) {
        super(1006000);
        this.a = fVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(HttpResponsedMessage httpResponsedMessage) {
        i iVar;
        i iVar2;
        i iVar3;
        HttpResponsedMessage httpResponsedMessage2 = httpResponsedMessage;
        if (httpResponsedMessage2 == null || httpResponsedMessage2.g() != 1006000) {
            return;
        }
        iVar = this.a.a;
        if (iVar != null) {
            int d = httpResponsedMessage2.d();
            int e = httpResponsedMessage2.e();
            if (d != 200 || e != 0 || !(httpResponsedMessage2 instanceof ResponseBubbleListMessage)) {
                iVar2 = this.a.a;
                iVar2.b(null);
                return;
            }
            iVar3 = this.a.a;
            iVar3.a(((ResponseBubbleListMessage) httpResponsedMessage2).i());
        }
    }
}
