package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes3.dex */
public class b {
    private long flb;
    private long flc;
    private long fld;
    private String forumAvatar;
    private long forumId;
    private String forumName;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.flb = forumInfo.time_out.longValue();
            this.flc = forumInfo.member_count.longValue();
            this.fld = forumInfo.thread_count.longValue();
        }
    }
}
