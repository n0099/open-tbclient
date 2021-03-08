package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes7.dex */
public class b {
    private String forumAvatar;
    private long forumId;
    private String forumName;
    private long lkQ;
    private long lkR;
    private long lkS;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.lkQ = forumInfo.time_out.longValue();
            this.lkR = forumInfo.member_count.longValue();
            this.lkS = forumInfo.thread_count.longValue();
        }
    }
}
