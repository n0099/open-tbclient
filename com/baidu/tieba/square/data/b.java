package com.baidu.tieba.square.data;

import com.baidu.adp.BdUniqueId;
import tbclient.RecommendForumInfo;
/* loaded from: classes22.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public String avatar;
    public boolean exi;
    public String extInfo;
    public long forumId;
    public String forumName;
    public String ihb;
    public int memberCount;
    public int threadCount;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
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
        return this.exi;
    }

    public void setLike(boolean z) {
        this.exi = z;
    }

    public int getMemberCount() {
        return this.memberCount;
    }

    public int dFJ() {
        return this.threadCount;
    }

    public String bhA() {
        return this.ihb;
    }

    public void c(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            this.forumId = recommendForumInfo.forum_id.longValue();
            this.forumName = recommendForumInfo.forum_name;
            this.avatar = recommendForumInfo.avatar;
            this.memberCount = recommendForumInfo.member_count.intValue();
            this.threadCount = recommendForumInfo.thread_count.intValue();
            this.exi = recommendForumInfo.is_like.intValue() == 1;
            this.ihb = recommendForumInfo.recom_reason;
            this.extInfo = recommendForumInfo.extra;
        }
    }
}
