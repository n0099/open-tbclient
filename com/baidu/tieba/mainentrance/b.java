package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes9.dex */
public class b {
    private String forumAvatar;
    private long forumId;
    private String forumName;
    private long icM;
    private long icN;
    private long icO;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.icM = forumInfo.time_out.longValue();
            this.icN = forumInfo.member_count.longValue();
            this.icO = forumInfo.thread_count.longValue();
        }
    }
}
