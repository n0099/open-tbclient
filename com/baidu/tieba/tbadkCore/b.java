package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int npa = 0;
    private int npb = 0;

    public void a(Group group) {
        if (group != null) {
            this.npa = group.group_count.intValue();
            this.npb = group.hide_recommend_group.intValue();
        }
    }
}
