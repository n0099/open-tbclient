package com.baidu.tieba.recommendfrs.data;

import com.baidu.adp.lib.cache.t;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import tbclient.FineFrsPage.FineFrsPageResIdl;
/* loaded from: classes.dex */
public class RecommendFrsSocketResponsedMessage extends MvcSocketResponsedMessage<c, FineFrsPageResIdl> {
    public RecommendFrsSocketResponsedMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
    protected Class<FineFrsPageResIdl> getProtobufResponseIdlClass() {
        return FineFrsPageResIdl.class;
    }

    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        t<byte[]> bW;
        if (getOrginalMessage().getExtra() instanceof MvcNetMessage) {
            MvcNetMessage mvcNetMessage = (MvcNetMessage) getOrginalMessage().getExtra();
            if ((mvcNetMessage.getRequestData() instanceof d) && ((d) mvcNetMessage.getRequestData()).afW() == 0 && (bW = com.baidu.tbadk.core.b.a.rc().bW("RecommendFrsCache")) != null) {
                bW.f("RecommendFrsData", bArr);
            }
        }
    }
}
