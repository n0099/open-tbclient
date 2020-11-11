package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes24.dex */
public class b {
    private String forumAvatar;
    private long forumId;
    private String forumName;
    private long kLR;
    private long kLS;
    private long kLT;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.kLR = forumInfo.time_out.longValue();
            this.kLS = forumInfo.member_count.longValue();
            this.kLT = forumInfo.thread_count.longValue();
        }
    }
}
