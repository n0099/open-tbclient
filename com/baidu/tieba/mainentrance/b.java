package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes24.dex */
public class b {
    private String forumAvatar;
    private long forumId;
    private String forumName;
    private long kZx;
    private long kZy;
    private long kZz;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.kZx = forumInfo.time_out.longValue();
            this.kZy = forumInfo.member_count.longValue();
            this.kZz = forumInfo.thread_count.longValue();
        }
    }
}
