package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes.dex */
public class c {
    private long cLv;
    private long cLw;
    private long cLx;
    private String forumAvatar;
    private long forumId;
    private String forumName;

    public long getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String aoy() {
        return this.forumAvatar;
    }

    public long aoz() {
        return this.cLw;
    }

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.cLv = forumInfo.time_out.longValue();
            this.cLw = forumInfo.member_count.longValue();
            this.cLx = forumInfo.thread_count.longValue();
        }
    }
}
