package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes3.dex */
public class b {
    private long eBR;
    private long eBS;
    private long eBT;
    private String forumAvatar;
    private long forumId;
    private String forumName;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.eBR = forumInfo.time_out.longValue();
            this.eBS = forumInfo.member_count.longValue();
            this.eBT = forumInfo.thread_count.longValue();
        }
    }
}
