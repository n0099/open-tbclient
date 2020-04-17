package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes11.dex */
public class b {
    private String forumAvatar;
    private long forumId;
    private String forumName;
    private long iQE;
    private long iQF;
    private long iQG;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.iQE = forumInfo.time_out.longValue();
            this.iQF = forumInfo.member_count.longValue();
            this.iQG = forumInfo.thread_count.longValue();
        }
    }
}
