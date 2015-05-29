package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes.dex */
public class e {
    private long bBA;
    private long bBB;
    private String bBy;
    private long bBz;
    private long forumId;
    private String forumName;

    public String getForumName() {
        return this.forumName;
    }

    public String Yf() {
        return this.bBy;
    }

    public long Yg() {
        return this.bBA;
    }

    public long Yh() {
        return this.bBB;
    }

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.bBy = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.bBz = forumInfo.time_out.longValue();
            this.bBA = forumInfo.member_count.longValue();
            this.bBB = forumInfo.thread_count.longValue();
        }
    }
}
