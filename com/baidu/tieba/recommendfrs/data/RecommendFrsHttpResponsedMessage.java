package com.baidu.tieba.recommendfrs.data;

import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import tbclient.ExcFrsPage.ExcFrsPageResIdl;
/* loaded from: classes.dex */
public class RecommendFrsHttpResponsedMessage extends MvcProtobufHttpResponsedMessage<j, ExcFrsPageResIdl> {
    public RecommendFrsHttpResponsedMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
    protected Class<ExcFrsPageResIdl> getProtobufResponseIdlClass() {
        return ExcFrsPageResIdl.class;
    }

    @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        com.baidu.adp.lib.cache.o<byte[]> cA;
        if (getOrginalMessage().getExtra() instanceof MvcNetMessage) {
            MvcNetMessage mvcNetMessage = (MvcNetMessage) getOrginalMessage().getExtra();
            if (mvcNetMessage.getRequestData() instanceof k) {
                k kVar = (k) mvcNetMessage.getRequestData();
                if (kVar.aFw() == 0 && (cA = com.baidu.tbadk.core.b.a.ug().cA("RecommendFrsCache")) != null) {
                    cA.f(new StringBuilder(String.valueOf(kVar.getTagCode())).toString(), bArr);
                }
            }
        }
    }
}
