package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int fhF = 0;
    private int fhG = 0;

    public int bdu() {
        return this.fhG;
    }

    public void a(Group group) {
        if (group != null) {
            this.fhF = group.group_count.intValue();
            this.fhG = group.hide_recommend_group.intValue();
        }
    }
}
