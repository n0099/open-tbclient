package com.baidu.tieba.write.transmit.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.f.b;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.t;
import tbclient.GetRepostRecommendForum.DataReq;
import tbclient.GetRepostRecommendForum.GetRepostRecommendForumReqIdl;
/* loaded from: classes13.dex */
public class GetRepostForumReqMessage extends NetMessage {
    private long forumId;
    private BdUniqueId mRequestId;
    private String threadContent;
    private String threadTitle;

    public GetRepostForumReqMessage() {
        super(1003323, CmdConfigSocket.CMD_GET_REPOST_RECOMMEND_FORUM);
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
                t.a(builder, true);
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
        this.forumId = b.toLong(str, 0L);
    }
}
