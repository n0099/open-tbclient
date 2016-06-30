package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int eUJ = 0;
    private int eUK = 0;

    public int bag() {
        return this.eUK;
    }

    public void a(Group group) {
        if (group != null) {
            this.eUJ = group.group_count.intValue();
            this.eUK = group.hide_recommend_group.intValue();
        }
    }
}
