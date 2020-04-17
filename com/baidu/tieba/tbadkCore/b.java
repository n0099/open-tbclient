package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int kPY = 0;
    private int kPZ = 0;

    public void a(Group group) {
        if (group != null) {
            this.kPY = group.group_count.intValue();
            this.kPZ = group.hide_recommend_group.intValue();
        }
    }
}
