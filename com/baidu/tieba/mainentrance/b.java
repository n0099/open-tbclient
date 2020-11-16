package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes23.dex */
public class b {
    private String forumAvatar;
    private long forumId;
    private String forumName;
    private long kMg;
    private long kMh;
    private long kMi;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.kMg = forumInfo.time_out.longValue();
            this.kMh = forumInfo.member_count.longValue();
            this.kMi = forumInfo.thread_count.longValue();
        }
    }
}
