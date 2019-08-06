package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int jdN = 0;
    private int jdO = 0;

    public void a(Group group) {
        if (group != null) {
            this.jdN = group.group_count.intValue();
            this.jdO = group.hide_recommend_group.intValue();
        }
    }
}
