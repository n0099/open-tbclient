package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int gXG = 0;
    private int gXH = 0;

    public void a(Group group) {
        if (group != null) {
            this.gXG = group.group_count.intValue();
            this.gXH = group.hide_recommend_group.intValue();
        }
    }
}
