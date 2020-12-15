package com.baidu.tieba.square.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.RecommendForumInfo;
/* loaded from: classes22.dex */
public class b extends BaseCardInfo {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public String avatar;
    public boolean eIr;
    public String extInfo;
    public long forumId;
    public String forumName;
    public String iyI;
    public int memberCount;
    public int threadCount;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
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
        return this.eIr;
    }

    public void setLike(boolean z) {
        this.eIr = z;
    }

    public int getMemberCount() {
        return this.memberCount;
    }

    public int dNt() {
        return this.threadCount;
    }

    public String bmo() {
        return this.iyI;
    }

    public void c(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            this.forumId = recommendForumInfo.forum_id.longValue();
            this.forumName = recommendForumInfo.forum_name;
            this.avatar = recommendForumInfo.avatar;
            this.memberCount = recommendForumInfo.member_count.intValue();
            this.threadCount = recommendForumInfo.thread_count.intValue();
            this.eIr = recommendForumInfo.is_like.intValue() == 1;
            this.iyI = recommendForumInfo.recom_reason;
            this.extInfo = recommendForumInfo.extra;
        }
    }
}
