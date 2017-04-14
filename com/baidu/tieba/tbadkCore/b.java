package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int fsP = 0;
    private int fsQ = 0;

    public int bgg() {
        return this.fsQ;
    }

    public void a(Group group) {
        if (group != null) {
            this.fsP = group.group_count.intValue();
            this.fsQ = group.hide_recommend_group.intValue();
        }
    }
}
