package com.baidu.tieba.personExtra;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.m0.z0.w;
import tbclient.GetRecommendGodList.DataReq;
import tbclient.GetRecommendGodList.GetRecommendGodListReqIdl;
/* loaded from: classes5.dex */
public class RecommendGodReqMsg extends NetMessage {
    public int pageNum;
    public String portrait;

    public RecommendGodReqMsg() {
        super(CmdConfigHttp.CMD_GET_RECOMMEND_GOD_LIST, 309684);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        if (z) {
            w.a(builder, true);
        }
        builder.portrait = this.portrait;
        builder.pn = Integer.valueOf(this.pageNum);
        GetRecommendGodListReqIdl.Builder builder2 = new GetRecommendGodListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
