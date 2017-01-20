package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int fmG = 0;
    private int fmH = 0;

    public int bfF() {
        return this.fmH;
    }

    public void a(Group group) {
        if (group != null) {
            this.fmG = group.group_count.intValue();
            this.fmH = group.hide_recommend_group.intValue();
        }
    }
}
