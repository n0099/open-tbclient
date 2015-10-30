package com.baidu.tieba.recommendfrs.data;

import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import tbclient.FineFrsPage.FineFrsPageResIdl;
/* loaded from: classes.dex */
public class RecommendFrsHttpResponsedMessage extends MvcProtobufHttpResponsedMessage<g, FineFrsPageResIdl> {
    public RecommendFrsHttpResponsedMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
    protected Class<FineFrsPageResIdl> getProtobufResponseIdlClass() {
        return FineFrsPageResIdl.class;
    }

    @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        o<byte[]> cq;
        if (getOrginalMessage().getExtra() instanceof MvcNetMessage) {
            MvcNetMessage mvcNetMessage = (MvcNetMessage) getOrginalMessage().getExtra();
            if (mvcNetMessage.getRequestData() instanceof h) {
                h hVar = (h) mvcNetMessage.getRequestData();
                if (hVar.aqq() == 0 && (cq = com.baidu.tbadk.core.b.a.sL().cq("RecommendFrsCache")) != null) {
                    cq.f(hVar.aqk(), bArr);
                }
            }
        }
    }
}
