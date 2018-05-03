package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes3.dex */
public class b {
    private long eBO;
    private long eBP;
    private long eBQ;
    private String forumAvatar;
    private long forumId;
    private String forumName;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.eBO = forumInfo.time_out.longValue();
            this.eBP = forumInfo.member_count.longValue();
            this.eBQ = forumInfo.thread_count.longValue();
        }
    }
}
