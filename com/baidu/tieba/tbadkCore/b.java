package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int mOw = 0;
    private int mOx = 0;

    public void a(Group group) {
        if (group != null) {
            this.mOw = group.group_count.intValue();
            this.mOx = group.hide_recommend_group.intValue();
        }
    }
}
