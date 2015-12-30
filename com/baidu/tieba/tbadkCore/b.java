package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int dEk = 0;
    private int dEl = 0;

    public int aDH() {
        return this.dEl;
    }

    public void a(Group group) {
        if (group != null) {
            this.dEk = group.group_count.intValue();
            this.dEl = group.hide_recommend_group.intValue();
        }
    }
}
