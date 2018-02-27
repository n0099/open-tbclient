package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes3.dex */
public class b {
    private long fgY;
    private long fgZ;
    private long fha;
    private String forumAvatar;
    private long forumId;
    private String forumName;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.fgY = forumInfo.time_out.longValue();
            this.fgZ = forumInfo.member_count.longValue();
            this.fha = forumInfo.thread_count.longValue();
        }
    }
}
