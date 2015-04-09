package com.baidu.tieba.mainentrance;

import tbclient.HotForum.ForumInfo;
/* loaded from: classes.dex */
public class e {
    private String byO;
    private long byP;
    private long forumId;
    private String forumName;

    public String getForumName() {
        return this.forumName;
    }

    public String WM() {
        return this.byO;
    }

    public boolean WN() {
        return System.currentTimeMillis() > this.byP * 1000;
    }

    public void a(ForumInfo forumInfo) {
        if (forumInfo != null) {
            this.byO = forumInfo.avatar;
            this.forumId = forumInfo.forum_id.longValue();
            this.forumName = forumInfo.forum_name;
            this.byP = forumInfo.time_out.longValue();
        }
    }
}
