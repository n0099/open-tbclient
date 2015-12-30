package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes.dex */
public class c {
    private long coV;
    private long coW;
    private long coX;
    private String forumAvatar;
    private long forumId;
    private String forumName;

    public long getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String agg() {
        return this.forumAvatar;
    }

    public long agh() {
        return this.coW;
    }

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.coV = forumInfo.time_out.longValue();
            this.coW = forumInfo.member_count.longValue();
            this.coX = forumInfo.thread_count.longValue();
        }
    }
}
