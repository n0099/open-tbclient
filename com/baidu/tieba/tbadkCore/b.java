package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int iDT = 0;
    private int iDU = 0;

    public void a(Group group) {
        if (group != null) {
            this.iDT = group.group_count.intValue();
            this.iDU = group.hide_recommend_group.intValue();
        }
    }
}
