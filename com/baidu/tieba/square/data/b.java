package com.baidu.tieba.square.data;

import com.baidu.adp.BdUniqueId;
import tbclient.RecommendForumInfo;
/* loaded from: classes16.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public String avatar;
    public boolean dQY;
    public String extInfo;
    public long forumId;
    public String forumName;
    public String hlH;
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
        return this.dQY;
    }

    public void setLike(boolean z) {
        this.dQY = z;
    }

    public int getMemberCount() {
        return this.memberCount;
    }

    public int djv() {
        return this.threadCount;
    }

    public String aTO() {
        return this.hlH;
    }

    public void c(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            this.forumId = recommendForumInfo.forum_id.longValue();
            this.forumName = recommendForumInfo.forum_name;
            this.avatar = recommendForumInfo.avatar;
            this.memberCount = recommendForumInfo.member_count.intValue();
            this.threadCount = recommendForumInfo.thread_count.intValue();
            this.dQY = recommendForumInfo.is_like.intValue() == 1;
            this.hlH = recommendForumInfo.recom_reason;
            this.extInfo = recommendForumInfo.extra;
        }
    }
}
