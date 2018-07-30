package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes3.dex */
public class b {
    private long eWc;
    private long eWd;
    private long eWe;
    private String forumAvatar;
    private long forumId;
    private String forumName;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.eWc = forumInfo.time_out.longValue();
            this.eWd = forumInfo.member_count.longValue();
            this.eWe = forumInfo.thread_count.longValue();
        }
    }
}
