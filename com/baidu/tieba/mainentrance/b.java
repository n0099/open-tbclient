package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes11.dex */
public class b {
    private String forumAvatar;
    private long forumId;
    private String forumName;
    private long igB;
    private long igC;
    private long igD;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.igB = forumInfo.time_out.longValue();
            this.igC = forumInfo.member_count.longValue();
            this.igD = forumInfo.thread_count.longValue();
        }
    }
}
