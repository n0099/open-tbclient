package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int fsd = 0;
    private int fse = 0;

    public int bhG() {
        return this.fse;
    }

    public void a(Group group) {
        if (group != null) {
            this.fsd = group.group_count.intValue();
            this.fse = group.hide_recommend_group.intValue();
        }
    }
}
