package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int eqa = 0;
    private int eqb = 0;

    public int aRY() {
        return this.eqb;
    }

    public void a(Group group) {
        if (group != null) {
            this.eqa = group.group_count.intValue();
            this.eqb = group.hide_recommend_group.intValue();
        }
    }
}
