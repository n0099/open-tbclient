package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int gKA = 0;
    private int gKB = 0;

    public void a(Group group) {
        if (group != null) {
            this.gKA = group.group_count.intValue();
            this.gKB = group.hide_recommend_group.intValue();
        }
    }
}
