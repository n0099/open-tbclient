package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes11.dex */
public class b {
    private String forumAvatar;
    private long forumId;
    private String forumName;
    private long iQI;
    private long iQJ;
    private long iQK;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.iQI = forumInfo.time_out.longValue();
            this.iQJ = forumInfo.member_count.longValue();
            this.iQK = forumInfo.thread_count.longValue();
        }
    }
}
