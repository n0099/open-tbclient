package com.baidu.tieba.write.transmit.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.g.b;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.s;
import tbclient.GetRepostRecommendForum.DataReq;
import tbclient.GetRepostRecommendForum.GetRepostRecommendForumReqIdl;
/* loaded from: classes3.dex */
public class GetRepostForumReqMessage extends NetMessage {
    private long forumId;
    private BdUniqueId mRequestId;
    private String threadContent;
    private String threadTitle;

    public GetRepostForumReqMessage() {
        super(CmdConfigHttp.CMD_GET_REPOST_RECOMMEND_FORUM, 309450);
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
                s.bindCommonParamsToProtobufData(builder, true);
            }
            builder.title = this.threadTitle;
            builder.content = this.threadContent;
            builder.forum_id = Long.valueOf(this.forumId);
            GetRepostRecommendForumReqIdl.Builder builder2 = new GetRepostRecommendForumReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }

    public void setThreadTitle(String str) {
        this.threadTitle = str;
    }

    public void setThreadContent(String str) {
        this.threadContent = str;
    }

    public void setForumId(String str) {
        this.forumId = b.d(str, 0L);
    }
}
