package com.baidu.tieba.square.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.RecommendForumInfo;
/* loaded from: classes2.dex */
public class b extends BaseCardInfo {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public String avatar;
    public boolean eNy;
    public String extInfo;
    public long forumId;
    public String forumName;
    public String iGo;
    public int memberCount;
    public int threadCount;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
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
        return this.eNy;
    }

    public void setLike(boolean z) {
        this.eNy = z;
    }

    public int getMemberCount() {
        return this.memberCount;
    }

    public int dJu() {
        return this.threadCount;
    }

    public String bkW() {
        return this.iGo;
    }

    public void c(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            this.forumId = recommendForumInfo.forum_id.longValue();
            this.forumName = recommendForumInfo.forum_name;
            this.avatar = recommendForumInfo.avatar;
            this.memberCount = recommendForumInfo.member_count.intValue();
            this.threadCount = recommendForumInfo.thread_count.intValue();
            this.eNy = recommendForumInfo.is_like.intValue() == 1;
            this.iGo = recommendForumInfo.recom_reason;
            this.extInfo = recommendForumInfo.extra;
        }
    }
}
