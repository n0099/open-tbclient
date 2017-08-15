package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int ggD = 0;
    private int ggE = 0;

    public void a(Group group) {
        if (group != null) {
            this.ggD = group.group_count.intValue();
            this.ggE = group.hide_recommend_group.intValue();
        }
    }
}
