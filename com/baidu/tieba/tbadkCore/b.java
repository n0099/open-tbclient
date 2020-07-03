package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int lDw = 0;
    private int lDx = 0;

    public void a(Group group) {
        if (group != null) {
            this.lDw = group.group_count.intValue();
            this.lDx = group.hide_recommend_group.intValue();
        }
    }
}
