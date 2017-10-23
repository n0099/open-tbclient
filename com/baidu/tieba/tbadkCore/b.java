package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int gdr = 0;
    private int gds = 0;

    public void a(Group group) {
        if (group != null) {
            this.gdr = group.group_count.intValue();
            this.gds = group.hide_recommend_group.intValue();
        }
    }
}
