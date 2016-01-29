package com.baidu.tieba.recommendfrs.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import tbclient.GodFeed.GodFeedResIdl;
/* loaded from: classes.dex */
public class RecommendGodHttpResponsedMessage extends MvcProtobufHttpResponsedMessage<j, GodFeedResIdl> {
    public RecommendGodHttpResponsedMessage() {
        super(CmdConfigHttp.CMD_RECOMMEND_FRS_GOD);
    }

    @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
    protected Class<GodFeedResIdl> getProtobufResponseIdlClass() {
        return GodFeedResIdl.class;
    }

    @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        com.baidu.adp.lib.cache.o<byte[]> P;
        if (getOrginalMessage().getExtra() instanceof MvcNetMessage) {
            MvcNetMessage mvcNetMessage = (MvcNetMessage) getOrginalMessage().getExtra();
            if (mvcNetMessage.getRequestData() instanceof o) {
                o oVar = (o) mvcNetMessage.getRequestData();
                if (oVar.getPn() == 1 && (P = com.baidu.tbadk.core.b.a.ug().P("RecommendGodCache", TbadkCoreApplication.getCurrentAccount())) != null) {
                    P.f(new StringBuilder(String.valueOf(oVar.getTagCode())).toString(), bArr);
                }
            }
        }
    }
}
