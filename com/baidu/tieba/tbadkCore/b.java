package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int hhN = 0;
    private int hhO = 0;

    public void a(Group group) {
        if (group != null) {
            this.hhN = group.group_count.intValue();
            this.hhO = group.hide_recommend_group.intValue();
        }
    }
}
