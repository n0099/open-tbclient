package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int gUS = 0;
    private int gUT = 0;

    public void a(Group group) {
        if (group != null) {
            this.gUS = group.group_count.intValue();
            this.gUT = group.hide_recommend_group.intValue();
        }
    }
}
