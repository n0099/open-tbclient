package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes6.dex */
public class b {
    private String forumAvatar;
    private long forumId;
    private String forumName;
    private long hkA;
    private long hkB;
    private long hkz;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.hkz = forumInfo.time_out.longValue();
            this.hkA = forumInfo.member_count.longValue();
            this.hkB = forumInfo.thread_count.longValue();
        }
    }
}
