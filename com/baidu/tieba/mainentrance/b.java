package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes6.dex */
public class b {
    private String forumAvatar;
    private long forumId;
    private String forumName;
    private long hem;
    private long hen;
    private long heo;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.hem = forumInfo.time_out.longValue();
            this.hen = forumInfo.member_count.longValue();
            this.heo = forumInfo.thread_count.longValue();
        }
    }
}
