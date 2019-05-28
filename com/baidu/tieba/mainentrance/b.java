package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes6.dex */
public class b {
    private String forumAvatar;
    private long forumId;
    private String forumName;
    private long hel;
    private long hem;
    private long hen;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.hel = forumInfo.time_out.longValue();
            this.hem = forumInfo.member_count.longValue();
            this.hen = forumInfo.thread_count.longValue();
        }
    }
}
