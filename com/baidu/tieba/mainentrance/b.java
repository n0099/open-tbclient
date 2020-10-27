package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes24.dex */
public class b {
    private String forumAvatar;
    private long forumId;
    private String forumName;
    private long kFV;
    private long kFW;
    private long kFX;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.kFV = forumInfo.time_out.longValue();
            this.kFW = forumInfo.member_count.longValue();
            this.kFX = forumInfo.thread_count.longValue();
        }
    }
}
