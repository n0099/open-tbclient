package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes6.dex */
public class b {
    private String forumAvatar;
    private long forumId;
    private String forumName;
    private long hlY;
    private long hlZ;
    private long hma;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.hlY = forumInfo.time_out.longValue();
            this.hlZ = forumInfo.member_count.longValue();
            this.hma = forumInfo.thread_count.longValue();
        }
    }
}
