package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int keq = 0;
    private int ker = 0;

    public void a(Group group) {
        if (group != null) {
            this.keq = group.group_count.intValue();
            this.ker = group.hide_recommend_group.intValue();
        }
    }
}
