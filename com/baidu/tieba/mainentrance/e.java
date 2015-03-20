package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes.dex */
public class e {
    private String byy;
    private long byz;
    private long forumId;
    private String forumName;

    public String getForumName() {
        return this.forumName;
    }

    public String Wz() {
        return this.byy;
    }

    public boolean WA() {
        return System.currentTimeMillis() > this.byz * 1000;
    }

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.byy = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.byz = forumInfo.time_out.longValue();
        }
    }
}
