package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int iDw = 0;
    private int iDx = 0;

    public void a(Group group) {
        if (group != null) {
            this.iDw = group.group_count.intValue();
            this.iDx = group.hide_recommend_group.intValue();
        }
    }
}
