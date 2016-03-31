package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes.dex */
public class c {
    private long cKA;
    private long cKB;
    private long cKz;
    private String forumAvatar;
    private long forumId;
    private String forumName;

    public long getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String aor() {
        return this.forumAvatar;
    }

    public long aos() {
        return this.cKA;
    }

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.cKz = forumInfo.time_out.longValue();
            this.cKA = forumInfo.member_count.longValue();
            this.cKB = forumInfo.thread_count.longValue();
        }
    }
}
