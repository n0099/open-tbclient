package com.baidu.tieba.sdk.login.a;

import com.baidu.live.adp.framework.controller.HttpResponsedRule;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
/* loaded from: classes3.dex */
public class a extends HttpResponsedRule {
    public a(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.adp.framework.controller.ResponsedMessageRule
    /* renamed from: a */
    public HttpResponsedMessage process(HttpResponsedMessage httpResponsedMessage) {
        if ((httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001536) && (httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
            com.baidu.tieba.sdk.login.a cEu = com.baidu.tieba.sdk.login.a.cEu();
            if (((JsonHttpResponsedMessage) httpResponsedMessage).getError() == 1) {
                cEu.cdC();
                return null;
            }
            return httpResponsedMessage;
        }
        return httpResponsedMessage;
    }
}
