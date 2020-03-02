package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes11.dex */
public class b {
    private String forumAvatar;
    private long forumId;
    private String forumName;
    private long ieP;
    private long ieQ;
    private long ieR;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.ieP = forumInfo.time_out.longValue();
            this.ieQ = forumInfo.member_count.longValue();
            this.ieR = forumInfo.thread_count.longValue();
        }
    }
}
