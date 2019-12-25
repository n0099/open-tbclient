package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes8.dex */
public class b {
    private String forumAvatar;
    private long forumId;
    private String forumName;
    private long hZi;
    private long hZj;
    private long hZk;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.hZi = forumInfo.time_out.longValue();
            this.hZj = forumInfo.member_count.longValue();
            this.hZk = forumInfo.thread_count.longValue();
        }
    }
}
