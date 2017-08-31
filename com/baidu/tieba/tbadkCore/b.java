package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int gff = 0;
    private int gfg = 0;

    public void a(Group group) {
        if (group != null) {
            this.gff = group.group_count.intValue();
            this.gfg = group.hide_recommend_group.intValue();
        }
    }
}
