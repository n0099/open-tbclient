package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes3.dex */
public class b {
    private long eCW;
    private long eCX;
    private long eCY;
    private String forumAvatar;
    private long forumId;
    private String forumName;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.eCW = forumInfo.time_out.longValue();
            this.eCX = forumInfo.member_count.longValue();
            this.eCY = forumInfo.thread_count.longValue();
        }
    }
}
