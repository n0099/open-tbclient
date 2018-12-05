package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes3.dex */
public class b {
    private String forumAvatar;
    private long forumId;
    private String forumName;
    private long ftl;
    private long ftm;
    private long ftn;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.ftl = forumInfo.time_out.longValue();
            this.ftm = forumInfo.member_count.longValue();
            this.ftn = forumInfo.thread_count.longValue();
        }
    }
}
