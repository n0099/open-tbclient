package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int iWr = 0;
    private int iWs = 0;

    public void a(Group group) {
        if (group != null) {
            this.iWr = group.group_count.intValue();
            this.iWs = group.hide_recommend_group.intValue();
        }
    }
}
