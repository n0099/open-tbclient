package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes11.dex */
public class b {
    private String forumAvatar;
    private long forumId;
    private String forumName;
    private long jfJ;
    private long jfK;
    private long jfL;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.jfJ = forumInfo.time_out.longValue();
            this.jfK = forumInfo.member_count.longValue();
            this.jfL = forumInfo.thread_count.longValue();
        }
    }
}
