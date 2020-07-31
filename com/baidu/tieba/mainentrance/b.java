package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes18.dex */
public class b {
    private String forumAvatar;
    private long forumId;
    private String forumName;
    private long jGj;
    private long jGk;
    private long jGl;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.jGj = forumInfo.time_out.longValue();
            this.jGk = forumInfo.member_count.longValue();
            this.jGl = forumInfo.thread_count.longValue();
        }
    }
}
