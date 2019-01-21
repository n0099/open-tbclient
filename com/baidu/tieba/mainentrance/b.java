package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes3.dex */
public class b {
    private String forumAvatar;
    private long forumId;
    private String forumName;
    private long fwY;
    private long fwZ;
    private long fxa;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.fwY = forumInfo.time_out.longValue();
            this.fwZ = forumInfo.member_count.longValue();
            this.fxa = forumInfo.thread_count.longValue();
        }
    }
}
