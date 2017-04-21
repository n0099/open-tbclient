package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int fvg = 0;
    private int fvh = 0;

    public int bhi() {
        return this.fvh;
    }

    public void a(Group group) {
        if (group != null) {
            this.fvg = group.group_count.intValue();
            this.fvh = group.hide_recommend_group.intValue();
        }
    }
}
