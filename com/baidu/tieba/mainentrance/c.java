package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes.dex */
public class c {
    private long bUd;
    private long bUe;
    private long bUf;
    private String forumAvatar;
    private long forumId;
    private String forumName;

    public long getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String aaW() {
        return this.forumAvatar;
    }

    public long aaX() {
        return this.bUe;
    }

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.bUd = forumInfo.time_out.longValue();
            this.bUe = forumInfo.member_count.longValue();
            this.bUf = forumInfo.thread_count.longValue();
        }
    }
}
