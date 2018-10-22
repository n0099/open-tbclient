package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes3.dex */
public class b {
    private long flc;
    private long fld;
    private long fle;
    private String forumAvatar;
    private long forumId;
    private String forumName;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.flc = forumInfo.time_out.longValue();
            this.fld = forumInfo.member_count.longValue();
            this.fle = forumInfo.thread_count.longValue();
        }
    }
}
