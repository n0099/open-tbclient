package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int dUl = 0;
    private int dUm = 0;

    public int aKM() {
        return this.dUm;
    }

    public void a(Group group) {
        if (group != null) {
            this.dUl = group.group_count.intValue();
            this.dUm = group.hide_recommend_group.intValue();
        }
    }
}
