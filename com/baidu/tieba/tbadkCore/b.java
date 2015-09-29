package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int cWl = 0;
    private int cWm = 0;

    public int avm() {
        return this.cWm;
    }

    public void a(Group group) {
        if (group != null) {
            this.cWl = group.group_count.intValue();
            this.cWm = group.hide_recommend_group.intValue();
        }
    }
}
