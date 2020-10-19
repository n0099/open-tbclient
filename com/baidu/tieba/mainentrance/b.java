package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes24.dex */
public class b {
    private String forumAvatar;
    private long forumId;
    private String forumName;
    private long ktA;
    private long kty;
    private long ktz;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.kty = forumInfo.time_out.longValue();
            this.ktz = forumInfo.member_count.longValue();
            this.ktA = forumInfo.thread_count.longValue();
        }
    }
}
