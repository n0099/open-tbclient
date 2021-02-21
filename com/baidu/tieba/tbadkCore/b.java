package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int nuC = 0;
    private int nuD = 0;

    public void a(Group group) {
        if (group != null) {
            this.nuC = group.group_count.intValue();
            this.nuD = group.hide_recommend_group.intValue();
        }
    }
}
