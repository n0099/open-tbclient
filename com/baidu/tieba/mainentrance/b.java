package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes6.dex */
public class b {
    private String forumAvatar;
    private long forumId;
    private String forumName;
    private long gNb;
    private long gNc;
    private long gNd;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.gNb = forumInfo.time_out.longValue();
            this.gNc = forumInfo.member_count.longValue();
            this.gNd = forumInfo.thread_count.longValue();
        }
    }
}
