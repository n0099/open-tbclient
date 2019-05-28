package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int iWn = 0;
    private int iWo = 0;

    public void a(Group group) {
        if (group != null) {
            this.iWn = group.group_count.intValue();
            this.iWo = group.hide_recommend_group.intValue();
        }
    }
}
