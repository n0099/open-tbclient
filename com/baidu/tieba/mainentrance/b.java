package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes23.dex */
public class b {
    private String forumAvatar;
    private long forumId;
    private String forumName;
    private long kek;
    private long kel;
    private long kem;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.kek = forumInfo.time_out.longValue();
            this.kel = forumInfo.member_count.longValue();
            this.kem = forumInfo.thread_count.longValue();
        }
    }
}
