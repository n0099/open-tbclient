package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes11.dex */
public class b {
    private String forumAvatar;
    private long forumId;
    private String forumName;
    private long ifb;
    private long ifc;
    private long ifd;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.ifb = forumInfo.time_out.longValue();
            this.ifc = forumInfo.member_count.longValue();
            this.ifd = forumInfo.thread_count.longValue();
        }
    }
}
