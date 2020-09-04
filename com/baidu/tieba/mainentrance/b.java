package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes18.dex */
public class b {
    private String forumAvatar;
    private long forumId;
    private String forumName;
    private long jVI;
    private long jVJ;
    private long jVK;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.jVI = forumInfo.time_out.longValue();
            this.jVJ = forumInfo.member_count.longValue();
            this.jVK = forumInfo.thread_count.longValue();
        }
    }
}
