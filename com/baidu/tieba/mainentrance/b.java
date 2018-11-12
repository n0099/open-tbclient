package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes3.dex */
public class b {
    private long fmt;
    private long fmu;
    private long fmv;
    private String forumAvatar;
    private long forumId;
    private String forumName;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.fmt = forumInfo.time_out.longValue();
            this.fmu = forumInfo.member_count.longValue();
            this.fmv = forumInfo.thread_count.longValue();
        }
    }
}
