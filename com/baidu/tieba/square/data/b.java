package com.baidu.tieba.square.data;

import com.baidu.adp.BdUniqueId;
import tbclient.RecommendForumInfo;
/* loaded from: classes9.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public String avatar;
    public boolean dqh;
    public String extInfo;
    public long forumId;
    public String forumName;
    public String gEp;
    public int memberCount;
    public int threadCount;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return TYPE;
    }

    public long getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public boolean isLike() {
        return this.dqh;
    }

    public void setLike(boolean z) {
        this.dqh = z;
    }

    public int getMemberCount() {
        return this.memberCount;
    }

    public int cUF() {
        return this.threadCount;
    }

    public String aIx() {
        return this.gEp;
    }

    public void c(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            this.forumId = recommendForumInfo.forum_id.longValue();
            this.forumName = recommendForumInfo.forum_name;
            this.avatar = recommendForumInfo.avatar;
            this.memberCount = recommendForumInfo.member_count.intValue();
            this.threadCount = recommendForumInfo.thread_count.intValue();
            this.dqh = recommendForumInfo.is_like.intValue() == 1;
            this.gEp = recommendForumInfo.recom_reason;
            this.extInfo = recommendForumInfo.extra;
        }
    }
}
