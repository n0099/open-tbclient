package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int jgi = 0;
    private int jgj = 0;

    public void a(Group group) {
        if (group != null) {
            this.jgi = group.group_count.intValue();
            this.jgj = group.hide_recommend_group.intValue();
        }
    }
}
