package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes18.dex */
public class b {
    private String forumAvatar;
    private long forumId;
    private String forumName;
    private long jVC;
    private long jVD;
    private long jVE;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.jVC = forumInfo.time_out.longValue();
            this.jVD = forumInfo.member_count.longValue();
            this.jVE = forumInfo.thread_count.longValue();
        }
    }
}
