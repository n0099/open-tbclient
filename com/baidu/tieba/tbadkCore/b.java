package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int mml = 0;
    private int mmm = 0;

    public void a(Group group) {
        if (group != null) {
            this.mml = group.group_count.intValue();
            this.mmm = group.hide_recommend_group.intValue();
        }
    }
}
