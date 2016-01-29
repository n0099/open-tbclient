package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes.dex */
public class c {
    private long cvE;
    private long cvF;
    private long cvG;
    private String forumAvatar;
    private long forumId;
    private String forumName;

    public long getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String aki() {
        return this.forumAvatar;
    }

    public long akj() {
        return this.cvF;
    }

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.cvE = forumInfo.time_out.longValue();
            this.cvF = forumInfo.member_count.longValue();
            this.cvG = forumInfo.thread_count.longValue();
        }
    }
}
