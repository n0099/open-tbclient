package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes3.dex */
public class b {
    private long fhk;
    private long fhl;
    private long fhm;
    private String forumAvatar;
    private long forumId;
    private String forumName;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.fhk = forumInfo.time_out.longValue();
            this.fhl = forumInfo.member_count.longValue();
            this.fhm = forumInfo.thread_count.longValue();
        }
    }
}
