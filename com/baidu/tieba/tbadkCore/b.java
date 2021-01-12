package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int nkt = 0;
    private int nku = 0;

    public void a(Group group) {
        if (group != null) {
            this.nkt = group.group_count.intValue();
            this.nku = group.hide_recommend_group.intValue();
        }
    }
}
