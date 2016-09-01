package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int fpx = 0;
    private int fpy = 0;

    public int bgY() {
        return this.fpy;
    }

    public void a(Group group) {
        if (group != null) {
            this.fpx = group.group_count.intValue();
            this.fpy = group.hide_recommend_group.intValue();
        }
    }
}
