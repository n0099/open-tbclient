package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int gVm = 0;
    private int gVn = 0;

    public void a(Group group) {
        if (group != null) {
            this.gVm = group.group_count.intValue();
            this.gVn = group.hide_recommend_group.intValue();
        }
    }
}
