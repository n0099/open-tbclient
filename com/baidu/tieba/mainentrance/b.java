package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes18.dex */
public class b {
    private String forumAvatar;
    private long forumId;
    private String forumName;
    private long jGl;
    private long jGm;
    private long jGn;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.jGl = forumInfo.time_out.longValue();
            this.jGm = forumInfo.member_count.longValue();
            this.jGn = forumInfo.thread_count.longValue();
        }
    }
}
