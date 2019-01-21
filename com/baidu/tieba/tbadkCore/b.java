package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int hme = 0;
    private int hmf = 0;

    public void a(Group group) {
        if (group != null) {
            this.hme = group.group_count.intValue();
            this.hmf = group.hide_recommend_group.intValue();
        }
    }
}
