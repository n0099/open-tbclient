package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int njt = 0;
    private int nju = 0;

    public void a(Group group) {
        if (group != null) {
            this.njt = group.group_count.intValue();
            this.nju = group.hide_recommend_group.intValue();
        }
    }
}
