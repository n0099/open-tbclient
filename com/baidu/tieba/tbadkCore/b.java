package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int haV = 0;
    private int haW = 0;

    public void a(Group group) {
        if (group != null) {
            this.haV = group.group_count.intValue();
            this.haW = group.hide_recommend_group.intValue();
        }
    }
}
