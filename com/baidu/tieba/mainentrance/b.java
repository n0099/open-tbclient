package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes8.dex */
public class b {
    private String forumAvatar;
    private long forumId;
    private String forumName;
    private long liO;
    private long liP;
    private long liQ;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.liO = forumInfo.time_out.longValue();
            this.liP = forumInfo.member_count.longValue();
            this.liQ = forumInfo.thread_count.longValue();
        }
    }
}
