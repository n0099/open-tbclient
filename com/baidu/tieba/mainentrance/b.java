package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes3.dex */
public class b {
    private String forumAvatar;
    private long forumId;
    private String forumName;
    private long fwX;
    private long fwY;
    private long fwZ;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.fwX = forumInfo.time_out.longValue();
            this.fwY = forumInfo.member_count.longValue();
            this.fwZ = forumInfo.thread_count.longValue();
        }
    }
}
