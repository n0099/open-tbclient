package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int noZ = 0;
    private int npa = 0;

    public void a(Group group) {
        if (group != null) {
            this.noZ = group.group_count.intValue();
            this.npa = group.hide_recommend_group.intValue();
        }
    }
}
