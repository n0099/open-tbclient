package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes.dex */
public class e {
    private long bBA;
    private long bBB;
    private long bBC;
    private String bBz;
    private long forumId;
    private String forumName;

    public String getForumName() {
        return this.forumName;
    }

    public String Yg() {
        return this.bBz;
    }

    public long Yh() {
        return this.bBB;
    }

    public long Yi() {
        return this.bBC;
    }

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.bBz = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.bBA = forumInfo.time_out.longValue();
            this.bBB = forumInfo.member_count.longValue();
            this.bBC = forumInfo.thread_count.longValue();
        }
    }
}
