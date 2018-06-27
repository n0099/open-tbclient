package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int gJC = 0;
    private int gJD = 0;

    public void a(Group group) {
        if (group != null) {
            this.gJC = group.group_count.intValue();
            this.gJD = group.hide_recommend_group.intValue();
        }
    }
}
