package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int frj = 0;
    private int frk = 0;

    public void a(Group group) {
        if (group != null) {
            this.frj = group.group_count.intValue();
            this.frk = group.hide_recommend_group.intValue();
        }
    }
}
