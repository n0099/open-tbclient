package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes11.dex */
public class b {
    private String forumAvatar;
    private long forumId;
    private String forumName;
    private long ieN;
    private long ieO;
    private long ieP;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.ieN = forumInfo.time_out.longValue();
            this.ieO = forumInfo.member_count.longValue();
            this.ieP = forumInfo.thread_count.longValue();
        }
    }
}
