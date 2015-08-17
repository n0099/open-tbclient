package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int cGy = 0;
    private int cGz = 0;

    public int aoP() {
        return this.cGz;
    }

    public void a(Group group) {
        if (group != null) {
            this.cGy = group.group_count.intValue();
            this.cGz = group.hide_recommend_group.intValue();
        }
    }
}
