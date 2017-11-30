package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int gvV = 0;
    private int gvW = 0;

    public void a(Group group) {
        if (group != null) {
            this.gvV = group.group_count.intValue();
            this.gvW = group.hide_recommend_group.intValue();
        }
    }
}
