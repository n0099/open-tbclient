package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int gSb = 0;
    private int gSc = 0;

    public void a(Group group) {
        if (group != null) {
            this.gSb = group.group_count.intValue();
            this.gSc = group.hide_recommend_group.intValue();
        }
    }
}
