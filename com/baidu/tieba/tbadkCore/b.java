package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int kee = 0;
    private int kef = 0;

    public void a(Group group) {
        if (group != null) {
            this.kee = group.group_count.intValue();
            this.kef = group.hide_recommend_group.intValue();
        }
    }
}
