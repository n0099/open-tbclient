package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int gXF = 0;
    private int gXG = 0;

    public void a(Group group) {
        if (group != null) {
            this.gXF = group.group_count.intValue();
            this.gXG = group.hide_recommend_group.intValue();
        }
    }
}
