package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes6.dex */
public class b {
    private String forumAvatar;
    private long forumId;
    private String forumName;
    private long hlh;
    private long hli;
    private long hlj;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.hlh = forumInfo.time_out.longValue();
            this.hli = forumInfo.member_count.longValue();
            this.hlj = forumInfo.thread_count.longValue();
        }
    }
}
