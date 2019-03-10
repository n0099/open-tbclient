package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int iDU = 0;
    private int iDV = 0;

    public void a(Group group) {
        if (group != null) {
            this.iDU = group.group_count.intValue();
            this.iDV = group.hide_recommend_group.intValue();
        }
    }
}
