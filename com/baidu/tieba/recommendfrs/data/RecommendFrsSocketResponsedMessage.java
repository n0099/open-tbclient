package com.baidu.tieba.recommendfrs.data;

import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import tbclient.ExcFrsPage.ExcFrsPageResIdl;
/* loaded from: classes.dex */
public class RecommendFrsSocketResponsedMessage extends MvcSocketResponsedMessage<n, ExcFrsPageResIdl> {
    public RecommendFrsSocketResponsedMessage() {
        super(309092);
    }

    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
    protected Class<ExcFrsPageResIdl> getProtobufResponseIdlClass() {
        return ExcFrsPageResIdl.class;
    }

    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        com.baidu.adp.lib.cache.o<byte[]> cw;
        if (getOrginalMessage().getExtra() instanceof MvcNetMessage) {
            MvcNetMessage mvcNetMessage = (MvcNetMessage) getOrginalMessage().getExtra();
            if (mvcNetMessage.getRequestData() instanceof o) {
                o oVar = (o) mvcNetMessage.getRequestData();
                if (oVar.aMv() == 0 && (cw = com.baidu.tbadk.core.b.a.rR().cw("RecommendFrsCache")) != null) {
                    cw.e(new StringBuilder(String.valueOf(oVar.getTagCode())).toString(), bArr);
                }
            }
        }
    }
}
