package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int gKy = 0;
    private int gKz = 0;

    public void a(Group group) {
        if (group != null) {
            this.gKy = group.group_count.intValue();
            this.gKz = group.hide_recommend_group.intValue();
        }
    }
}
