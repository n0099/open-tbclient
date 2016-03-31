package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int emL = 0;
    private int emM = 0;

    public int aRB() {
        return this.emM;
    }

    public void a(Group group) {
        if (group != null) {
            this.emL = group.group_count.intValue();
            this.emM = group.hide_recommend_group.intValue();
        }
    }
}
