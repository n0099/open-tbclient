package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes8.dex */
public class b {
    private String forumAvatar;
    private long forumId;
    private String forumName;
    private long lfe;
    private long lff;
    private long lfg;

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.forumAvatar = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.lfe = forumInfo.time_out.longValue();
            this.lff = forumInfo.member_count.longValue();
            this.lfg = forumInfo.thread_count.longValue();
        }
    }
}
