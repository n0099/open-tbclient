package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes.dex */
public class c {
    private long bUE;
    private long bUF;
    private long bUG;
    private String forumAvatar;
    private long forumId;
    private String forumName;

    public long getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String abr() {
        return this.forumAvatar;
    }

    public long abs() {
        return this.bUF;
    }

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.bUE = forumInfo.time_out.longValue();
            this.bUF = forumInfo.member_count.longValue();
            this.bUG = forumInfo.thread_count.longValue();
        }
    }
}
