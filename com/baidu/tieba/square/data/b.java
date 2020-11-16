package com.baidu.tieba.square.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.RecommendForumInfo;
/* loaded from: classes21.dex */
public class b extends BaseCardInfo {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public String avatar;
    public boolean eBr;
    public String extInfo;
    public long forumId;
    public String forumName;
    public String inO;
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
        return this.eBr;
    }

    public void setLike(boolean z) {
        this.eBr = z;
    }

    public int getMemberCount() {
        return this.memberCount;
    }

    public int dIc() {
        return this.threadCount;
    }

    public String bje() {
        return this.inO;
    }

    public void c(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            this.forumId = recommendForumInfo.forum_id.longValue();
            this.forumName = recommendForumInfo.forum_name;
            this.avatar = recommendForumInfo.avatar;
            this.memberCount = recommendForumInfo.member_count.intValue();
            this.threadCount = recommendForumInfo.thread_count.intValue();
            this.eBr = recommendForumInfo.is_like.intValue() == 1;
            this.inO = recommendForumInfo.recom_reason;
            this.extInfo = recommendForumInfo.extra;
        }
    }
}
