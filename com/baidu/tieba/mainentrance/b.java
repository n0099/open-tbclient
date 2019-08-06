package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes6.dex */
public class b {
    private String forumAvatar;
    private long forumId;
    private String forumName;
    private long hlr;
    private long hls;
    private long hlt;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.hlr = forumInfo.time_out.longValue();
            this.hls = forumInfo.member_count.longValue();
            this.hlt = forumInfo.thread_count.longValue();
        }
    }
}
