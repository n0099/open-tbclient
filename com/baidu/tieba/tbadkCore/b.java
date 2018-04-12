package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int gtk = 0;
    private int gtl = 0;

    public void a(Group group) {
        if (group != null) {
            this.gtk = group.group_count.intValue();
            this.gtl = group.hide_recommend_group.intValue();
        }
    }
}
