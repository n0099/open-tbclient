package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes6.dex */
public class b {
    private String forumAvatar;
    private long forumId;
    private String forumName;
    private long gMP;
    private long gMQ;
    private long gMR;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.gMP = forumInfo.time_out.longValue();
            this.gMQ = forumInfo.member_count.longValue();
            this.gMR = forumInfo.thread_count.longValue();
        }
    }
}
