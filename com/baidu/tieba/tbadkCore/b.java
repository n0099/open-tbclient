package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int bRG = 0;
    private int bRH = 0;

    public int aeb() {
        return this.bRG;
    }

    public int aec() {
        return this.bRH;
    }

    public void a(Group group) {
        if (group != null) {
            this.bRG = group.group_count.intValue();
            this.bRH = group.hide_recommend_group.intValue();
        }
    }
}
