package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int nub = 0;
    private int nuc = 0;

    public void a(Group group) {
        if (group != null) {
            this.nub = group.group_count.intValue();
            this.nuc = group.hide_recommend_group.intValue();
        }
    }
}
