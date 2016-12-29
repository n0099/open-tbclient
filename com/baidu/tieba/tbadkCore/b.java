package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int fdl = 0;
    private int fdm = 0;

    public int bdS() {
        return this.fdm;
    }

    public void a(Group group) {
        if (group != null) {
            this.fdl = group.group_count.intValue();
            this.fdm = group.hide_recommend_group.intValue();
        }
    }
}
