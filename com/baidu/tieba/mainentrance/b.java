package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes3.dex */
public class b {
    private long fhm;
    private long fhn;
    private long fho;
    private String forumAvatar;
    private long forumId;
    private String forumName;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.fhm = forumInfo.time_out.longValue();
            this.fhn = forumInfo.member_count.longValue();
            this.fho = forumInfo.thread_count.longValue();
        }
    }
}
