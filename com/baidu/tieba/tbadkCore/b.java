package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int mVt = 0;
    private int mVu = 0;

    public void a(Group group) {
        if (group != null) {
            this.mVt = group.group_count.intValue();
            this.mVu = group.hide_recommend_group.intValue();
        }
    }
}
