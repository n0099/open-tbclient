package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int cjV = 0;
    private int cjW = 0;

    public int akm() {
        return this.cjV;
    }

    public int akn() {
        return this.cjW;
    }

    public void a(Group group) {
        if (group != null) {
            this.cjV = group.group_count.intValue();
            this.cjW = group.hide_recommend_group.intValue();
        }
    }
}
