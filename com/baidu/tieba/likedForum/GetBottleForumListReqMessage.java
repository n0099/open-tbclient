package com.baidu.tieba.likedForum;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.n;
import tbclient.RecommendForumListForBottle.DataReq;
import tbclient.RecommendForumListForBottle.RecommendForumListForBottleReqIdl;
/* loaded from: classes.dex */
public class GetBottleForumListReqMessage extends NetMessage {
    public GetBottleForumListReqMessage() {
        super(CmdConfigHttp.CMD_GET_BOTTLE_FORUM_LIST, 309440);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            if (z) {
                n.bindCommonParamsToProtobufData(builder, true);
            }
            RecommendForumListForBottleReqIdl.Builder builder2 = new RecommendForumListForBottleReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}
