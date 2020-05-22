package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int lis = 0;
    private int lit = 0;

    public void a(Group group) {
        if (group != null) {
            this.lis = group.group_count.intValue();
            this.lit = group.hide_recommend_group.intValue();
        }
    }
}
