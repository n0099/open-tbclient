package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int lKL = 0;
    private int lKM = 0;

    public void a(Group group) {
        if (group != null) {
            this.lKL = group.group_count.intValue();
            this.lKM = group.hide_recommend_group.intValue();
        }
    }
}
