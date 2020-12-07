package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int njr = 0;
    private int njs = 0;

    public void a(Group group) {
        if (group != null) {
            this.njr = group.group_count.intValue();
            this.njs = group.hide_recommend_group.intValue();
        }
    }
}
