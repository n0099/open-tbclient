package com.baidu.tieba.write.transmit.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.c.e.m.b;
import d.b.i0.z0.w;
import tbclient.GetRepostRecommendForum.DataReq;
import tbclient.GetRepostRecommendForum.GetRepostRecommendForumReqIdl;
/* loaded from: classes5.dex */
public class GetRepostForumReqMessage extends NetMessage {
    public long forumId;
    public BdUniqueId mRequestId;
    public String threadContent;
    public String threadTitle;

    public GetRepostForumReqMessage() {
        super(CmdConfigHttp.CMD_GET_REPOST_RECOMMEND_FORUM, 309450);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            if (z) {
                w.a(builder, true);
            }
            builder.title = this.threadTitle;
            builder.content = this.threadContent;
            builder.forum_id = Long.valueOf(this.forumId);
            GetRepostRecommendForumReqIdl.Builder builder2 = new GetRepostRecommendForumReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception unused) {
            return null;
        }
    }

    public BdUniqueId getRequestId() {
        return this.mRequestId;
    }

    public void setForumId(String str) {
        this.forumId = b.f(str, 0L);
    }

    public void setRequestId(BdUniqueId bdUniqueId) {
        this.mRequestId = bdUniqueId;
    }

    public void setThreadContent(String str) {
        this.threadContent = str;
    }

    public void setThreadTitle(String str) {
        this.threadTitle = str;
    }
}
