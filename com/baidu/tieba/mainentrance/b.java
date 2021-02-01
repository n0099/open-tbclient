package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes8.dex */
public class b {
    private String forumAvatar;
    private long forumId;
    private String forumName;
    private long liA;
    private long liB;
    private long liC;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.liA = forumInfo.time_out.longValue();
            this.liB = forumInfo.member_count.longValue();
            this.liC = forumInfo.thread_count.longValue();
        }
    }
}
