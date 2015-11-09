package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int cYg = 0;
    private int cYh = 0;

    public int avV() {
        return this.cYh;
    }

    public void a(Group group) {
        if (group != null) {
            this.cYg = group.group_count.intValue();
            this.cYh = group.hide_recommend_group.intValue();
        }
    }
}
