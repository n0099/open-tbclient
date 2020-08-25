package com.baidu.tieba.j;

import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.framework.b.c {
    public b() {
        super(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.g
    /* renamed from: b */
    public HttpResponsedMessage a(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage != null && httpResponsedMessage.getError() == 1990055 && !a.zA(httpResponsedMessage.getCmd())) {
            a.cvF();
        }
        return httpResponsedMessage;
    }
}
