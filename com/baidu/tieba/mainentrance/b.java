package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes6.dex */
public class b {
    private String forumAvatar;
    private long forumId;
    private String forumName;
    private long hei;
    private long hej;
    private long hek;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.hei = forumInfo.time_out.longValue();
            this.hej = forumInfo.member_count.longValue();
            this.hek = forumInfo.thread_count.longValue();
        }
    }
}
