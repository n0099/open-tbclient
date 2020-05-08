package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int kQc = 0;
    private int kQd = 0;

    public void a(Group group) {
        if (group != null) {
            this.kQc = group.group_count.intValue();
            this.kQd = group.hide_recommend_group.intValue();
        }
    }
}
