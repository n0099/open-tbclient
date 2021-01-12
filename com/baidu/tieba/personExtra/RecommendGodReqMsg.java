package com.baidu.tieba.personExtra;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.t;
import tbclient.GetRecommendGodList.DataReq;
import tbclient.GetRecommendGodList.GetRecommendGodListReqIdl;
/* loaded from: classes7.dex */
public class RecommendGodReqMsg extends NetMessage {
    public int pageNum;
    public String portrait;

    public RecommendGodReqMsg() {
        super(CmdConfigHttp.CMD_GET_RECOMMEND_GOD_LIST, 309684);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        if (z) {
            t.b(builder, true);
        }
        builder.portrait = this.portrait;
        builder.pn = Integer.valueOf(this.pageNum);
        GetRecommendGodListReqIdl.Builder builder2 = new GetRecommendGodListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
