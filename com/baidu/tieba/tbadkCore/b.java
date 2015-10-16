package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int cWK = 0;
    private int cWL = 0;

    public int avs() {
        return this.cWL;
    }

    public void a(Group group) {
        if (group != null) {
            this.cWK = group.group_count.intValue();
            this.cWL = group.hide_recommend_group.intValue();
        }
    }
}
