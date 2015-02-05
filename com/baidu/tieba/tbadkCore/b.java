package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int bTs = 0;
    private int bTt = 0;

    public int aeA() {
        return this.bTs;
    }

    public int aeB() {
        return this.bTt;
    }

    public void a(Group group) {
        if (group != null) {
            this.bTs = group.group_count.intValue();
            this.bTt = group.hide_recommend_group.intValue();
        }
    }
}
