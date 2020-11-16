package com.baidu.tieba.likedForum;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.u;
import tbclient.RecommendForumListForBottle.DataReq;
import tbclient.RecommendForumListForBottle.RecommendForumListForBottleReqIdl;
/* loaded from: classes20.dex */
public class GetBottleForumListReqMessage extends NetMessage {
    private BdUniqueId mRequestId;

    public GetBottleForumListReqMessage() {
        super(1003316, CmdConfigSocket.CMD_GET_BOTTLE_FORUM_LIST);
    }

    public void setRequestId(BdUniqueId bdUniqueId) {
        this.mRequestId = bdUniqueId;
    }

    public BdUniqueId getRequestId() {
        return this.mRequestId;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            if (z) {
                u.a(builder, true);
            }
            RecommendForumListForBottleReqIdl.Builder builder2 = new RecommendForumListForBottleReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}
