package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int iDM = 0;
    private int iDN = 0;

    public void a(Group group) {
        if (group != null) {
            this.iDM = group.group_count.intValue();
            this.iDN = group.hide_recommend_group.intValue();
        }
    }
}
