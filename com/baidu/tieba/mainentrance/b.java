package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes6.dex */
public class b {
    private String forumAvatar;
    private long forumId;
    private String forumName;
    private long gMO;
    private long gMP;
    private long gMQ;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.gMO = forumInfo.time_out.longValue();
            this.gMP = forumInfo.member_count.longValue();
            this.gMQ = forumInfo.thread_count.longValue();
        }
    }
}
