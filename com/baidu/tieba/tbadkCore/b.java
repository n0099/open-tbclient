package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int gyI = 0;
    private int gyJ = 0;

    public void a(Group group) {
        if (group != null) {
            this.gyI = group.group_count.intValue();
            this.gyJ = group.hide_recommend_group.intValue();
        }
    }
}
