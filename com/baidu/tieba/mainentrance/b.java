package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes11.dex */
public class b {
    private String forumAvatar;
    private long forumId;
    private String forumName;
    private long jxF;
    private long jxG;
    private long jxH;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.jxF = forumInfo.time_out.longValue();
            this.jxG = forumInfo.member_count.longValue();
            this.jxH = forumInfo.thread_count.longValue();
        }
    }
}
