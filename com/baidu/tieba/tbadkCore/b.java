package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int iWl = 0;
    private int iWm = 0;

    public void a(Group group) {
        if (group != null) {
            this.iWl = group.group_count.intValue();
            this.iWm = group.hide_recommend_group.intValue();
        }
    }
}
