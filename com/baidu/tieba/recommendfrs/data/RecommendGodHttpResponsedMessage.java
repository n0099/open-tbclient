package com.baidu.tieba.recommendfrs.data;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import tbclient.GodFeed.GodFeedResIdl;
/* loaded from: classes.dex */
public class RecommendGodHttpResponsedMessage extends MvcProtobufHttpResponsedMessage<n, GodFeedResIdl> {
    public RecommendGodHttpResponsedMessage() {
        super(CmdConfigHttp.CMD_RECOMMEND_FRS_GOD);
    }

    @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
    protected Class<GodFeedResIdl> getProtobufResponseIdlClass() {
        return GodFeedResIdl.class;
    }

    @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        com.baidu.adp.lib.cache.o<byte[]> N;
        if (getOrginalMessage().getExtra() instanceof MvcNetMessage) {
            MvcNetMessage mvcNetMessage = (MvcNetMessage) getOrginalMessage().getExtra();
            if (mvcNetMessage.getRequestData() instanceof s) {
                s sVar = (s) mvcNetMessage.getRequestData();
                if (sVar.getPn() == 1 && (N = com.baidu.tbadk.core.b.a.um().N("RecommendGodCache", TbadkCoreApplication.getCurrentAccount())) != null) {
                    N.e(new StringBuilder(String.valueOf(sVar.getTagCode())).toString(), bArr);
                }
            }
        }
    }
}
