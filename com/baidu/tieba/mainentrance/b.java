package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes3.dex */
public class b {
    private long eVX;
    private long eVY;
    private long eVZ;
    private String forumAvatar;
    private long forumId;
    private String forumName;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.eVX = forumInfo.time_out.longValue();
            this.eVY = forumInfo.member_count.longValue();
            this.eVZ = forumInfo.thread_count.longValue();
        }
    }
}
