package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes.dex */
public class c {
    private String bPI;
    private long bPJ;
    private long bPK;
    private long bPL;
    private long forumId;
    private String forumName;

    public String getForumName() {
        return this.forumName;
    }

    public String ZM() {
        return this.bPI;
    }

    public long ZN() {
        return this.bPK;
    }

    public long ZO() {
        return this.bPL;
    }

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.bPI = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.bPJ = forumInfo.time_out.longValue();
            this.bPK = forumInfo.member_count.longValue();
            this.bPL = forumInfo.thread_count.longValue();
        }
    }
}
