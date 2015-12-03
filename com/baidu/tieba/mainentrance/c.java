package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes.dex */
public class c {
    private long ckR;
    private long ckS;
    private long ckT;
    private String forumAvatar;
    private long forumId;
    private String forumName;

    public long getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public String aeX() {
        return this.forumAvatar;
    }

    public long aeY() {
        return this.ckS;
    }

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.ckR = forumInfo.time_out.longValue();
            this.ckS = forumInfo.member_count.longValue();
            this.ckT = forumInfo.thread_count.longValue();
        }
    }
}
