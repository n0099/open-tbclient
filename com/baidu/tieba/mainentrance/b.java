package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes3.dex */
public class b {
    private long eOq;
    private long eOr;
    private long eOs;
    private String forumAvatar;
    private long forumId;
    private String forumName;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.eOq = forumInfo.time_out.longValue();
            this.eOr = forumInfo.member_count.longValue();
            this.eOs = forumInfo.thread_count.longValue();
        }
    }
}
