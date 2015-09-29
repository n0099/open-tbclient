package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes.dex */
public class c {
    private long bTS;
    private long bTT;
    private long bTU;
    private String forumAvatar;
    private long forumId;
    private String forumName;

    public long getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String aba() {
        return this.forumAvatar;
    }

    public long abb() {
        return this.bTT;
    }

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.bTS = forumInfo.time_out.longValue();
            this.bTT = forumInfo.member_count.longValue();
            this.bTU = forumInfo.thread_count.longValue();
        }
    }
}
