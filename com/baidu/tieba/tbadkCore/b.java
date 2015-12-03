package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int dwK = 0;
    private int dwL = 0;

    public int aBz() {
        return this.dwL;
    }

    public void a(Group group) {
        if (group != null) {
            this.dwK = group.group_count.intValue();
            this.dwL = group.hide_recommend_group.intValue();
        }
    }
}
