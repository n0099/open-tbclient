package com.baidu.tieba.likedForum;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.i0.z0.w;
import tbclient.RecommendForumListForBottle.DataReq;
import tbclient.RecommendForumListForBottle.RecommendForumListForBottleReqIdl;
/* loaded from: classes4.dex */
public class GetBottleForumListReqMessage extends NetMessage {
    public BdUniqueId mRequestId;

    public GetBottleForumListReqMessage() {
        super(CmdConfigHttp.CMD_GET_BOTTLE_FORUM_LIST, 309440);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            if (z) {
                w.a(builder, true);
            }
            RecommendForumListForBottleReqIdl.Builder builder2 = new RecommendForumListForBottleReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception unused) {
            return null;
        }
    }

    public BdUniqueId getRequestId() {
        return this.mRequestId;
    }

    public void setRequestId(BdUniqueId bdUniqueId) {
        this.mRequestId = bdUniqueId;
    }
}
