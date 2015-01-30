package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int bTt = 0;
    private int bTu = 0;

    public int aeF() {
        return this.bTt;
    }

    public int aeG() {
        return this.bTu;
    }

    public void a(Group group) {
        if (group != null) {
            this.bTt = group.group_count.intValue();
            this.bTu = group.hide_recommend_group.intValue();
        }
    }
}
