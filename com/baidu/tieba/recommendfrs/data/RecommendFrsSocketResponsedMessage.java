package com.baidu.tieba.recommendfrs.data;

import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import tbclient.FineFrsPage.FineFrsPageResIdl;
/* loaded from: classes.dex */
public class RecommendFrsSocketResponsedMessage extends MvcSocketResponsedMessage<g, FineFrsPageResIdl> {
    public RecommendFrsSocketResponsedMessage() {
        super(307001);
    }

    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
    protected Class<FineFrsPageResIdl> getProtobufResponseIdlClass() {
        return FineFrsPageResIdl.class;
    }

    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        o<byte[]> cp;
        if (getOrginalMessage().getExtra() instanceof MvcNetMessage) {
            MvcNetMessage mvcNetMessage = (MvcNetMessage) getOrginalMessage().getExtra();
            if (mvcNetMessage.getRequestData() instanceof h) {
                h hVar = (h) mvcNetMessage.getRequestData();
                if (hVar.aqo() == 0 && (cp = com.baidu.tbadk.core.b.a.sO().cp("RecommendFrsCache")) != null) {
                    cp.f(hVar.aqi(), bArr);
                }
            }
        }
    }
}
