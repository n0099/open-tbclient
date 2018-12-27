package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int hkZ = 0;
    private int hla = 0;

    public void a(Group group) {
        if (group != null) {
            this.hkZ = group.group_count.intValue();
            this.hla = group.hide_recommend_group.intValue();
        }
    }
}
