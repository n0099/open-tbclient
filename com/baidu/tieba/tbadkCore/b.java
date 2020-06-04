package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int ljB = 0;
    private int ljC = 0;

    public void a(Group group) {
        if (group != null) {
            this.ljB = group.group_count.intValue();
            this.ljC = group.hide_recommend_group.intValue();
        }
    }
}
