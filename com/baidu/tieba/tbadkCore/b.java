package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int gXq = 0;
    private int gXr = 0;

    public void a(Group group) {
        if (group != null) {
            this.gXq = group.group_count.intValue();
            this.gXr = group.hide_recommend_group.intValue();
        }
    }
}
