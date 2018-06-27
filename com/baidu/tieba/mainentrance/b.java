package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes3.dex */
public class b {
    private long eSh;
    private long eSi;
    private long eSj;
    private String forumAvatar;
    private long forumId;
    private String forumName;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.eSh = forumInfo.time_out.longValue();
            this.eSi = forumInfo.member_count.longValue();
            this.eSj = forumInfo.thread_count.longValue();
        }
    }
}
