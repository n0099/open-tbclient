package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes3.dex */
public class b {
    private long fds;
    private long fdt;
    private long fdu;
    private String forumAvatar;
    private long forumId;
    private String forumName;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.fds = forumInfo.time_out.longValue();
            this.fdt = forumInfo.member_count.longValue();
            this.fdu = forumInfo.thread_count.longValue();
        }
    }
}
