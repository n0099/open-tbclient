package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int iDx = 0;
    private int iDy = 0;

    public void a(Group group) {
        if (group != null) {
            this.iDx = group.group_count.intValue();
            this.iDy = group.hide_recommend_group.intValue();
        }
    }
}
