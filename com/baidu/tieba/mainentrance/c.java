package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes.dex */
public class c {
    private String bQo;
    private long bQp;
    private long bQq;
    private long bQr;
    private long forumId;
    private String forumName;

    public String getForumName() {
        return this.forumName;
    }

    public String ZQ() {
        return this.bQo;
    }

    public long ZR() {
        return this.bQq;
    }

    public long ZS() {
        return this.bQr;
    }

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.bQo = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.bQp = forumInfo.time_out.longValue();
            this.bQq = forumInfo.member_count.longValue();
            this.bQr = forumInfo.thread_count.longValue();
        }
    }
}
