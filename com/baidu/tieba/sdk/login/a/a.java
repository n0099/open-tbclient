package com.baidu.tieba.sdk.login.a;

import com.baidu.live.adp.framework.controller.HttpResponsedRule;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
/* loaded from: classes6.dex */
public class a extends HttpResponsedRule {
    public a(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.adp.framework.controller.ResponsedMessageRule
    /* renamed from: a */
    public HttpResponsedMessage process(HttpResponsedMessage httpResponsedMessage) {
        if ((httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001536) && (httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
            com.baidu.tieba.sdk.login.a chL = com.baidu.tieba.sdk.login.a.chL();
            if (((JsonHttpResponsedMessage) httpResponsedMessage).getError() == 1) {
                chL.bJC();
                return null;
            }
            return httpResponsedMessage;
        }
        return httpResponsedMessage;
    }
}
