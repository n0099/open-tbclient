package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes11.dex */
public class b {
    private String forumAvatar;
    private long forumId;
    private String forumName;
    private long jgw;
    private long jgx;
    private long jgy;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.jgw = forumInfo.time_out.longValue();
            this.jgx = forumInfo.member_count.longValue();
            this.jgy = forumInfo.thread_count.longValue();
        }
    }
}
