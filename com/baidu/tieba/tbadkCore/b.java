package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int kfT = 0;
    private int kfU = 0;

    public void a(Group group) {
        if (group != null) {
            this.kfT = group.group_count.intValue();
            this.kfU = group.hide_recommend_group.intValue();
        }
    }
}
