package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int cOU = 0;
    private int cOV = 0;

    public int asW() {
        return this.cOV;
    }

    public void a(Group group) {
        if (group != null) {
            this.cOU = group.group_count.intValue();
            this.cOV = group.hide_recommend_group.intValue();
        }
    }
}
