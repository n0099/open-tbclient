package com.baidu.tieba.recommendfrs.data;

import com.baidu.adp.lib.cache.t;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import tbclient.FineFrsPage.FineFrsPageResIdl;
/* loaded from: classes.dex */
public class RecommendFrsSocketResponsedMessage extends MvcSocketResponsedMessage<f, FineFrsPageResIdl> {
    public RecommendFrsSocketResponsedMessage() {
        super(307001);
    }

    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
    protected Class<FineFrsPageResIdl> getProtobufResponseIdlClass() {
        return FineFrsPageResIdl.class;
    }

    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        t<byte[]> cj;
        if (getOrginalMessage().getExtra() instanceof MvcNetMessage) {
            MvcNetMessage mvcNetMessage = (MvcNetMessage) getOrginalMessage().getExtra();
            if (mvcNetMessage.getRequestData() instanceof g) {
                g gVar = (g) mvcNetMessage.getRequestData();
                if (gVar.ahI() == 0 && (cj = com.baidu.tbadk.core.b.a.rI().cj("RecommendFrsCache")) != null) {
                    cj.f(gVar.ahC(), bArr);
                }
            }
        }
    }
}
