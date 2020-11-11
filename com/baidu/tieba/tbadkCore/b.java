package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int mUA = 0;
    private int mUB = 0;

    public void a(Group group) {
        if (group != null) {
            this.mUA = group.group_count.intValue();
            this.mUB = group.hide_recommend_group.intValue();
        }
    }
}
