package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes3.dex */
public class b {
    private String forumAvatar;
    private long forumId;
    private String forumName;
    private long fwd;
    private long fwe;
    private long fwf;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.fwd = forumInfo.time_out.longValue();
            this.fwe = forumInfo.member_count.longValue();
            this.fwf = forumInfo.thread_count.longValue();
        }
    }
}
