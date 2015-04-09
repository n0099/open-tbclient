package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int ckl = 0;
    private int ckm = 0;

    public int akB() {
        return this.ckl;
    }

    public int akC() {
        return this.ckm;
    }

    public void a(Group group) {
        if (group != null) {
            this.ckl = group.group_count.intValue();
            this.ckm = group.hide_recommend_group.intValue();
        }
    }
}
