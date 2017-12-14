package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int gyD = 0;
    private int gyE = 0;

    public void a(Group group) {
        if (group != null) {
            this.gyD = group.group_count.intValue();
            this.gyE = group.hide_recommend_group.intValue();
        }
    }
}
