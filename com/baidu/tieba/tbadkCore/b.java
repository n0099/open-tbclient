package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int kcY = 0;
    private int kcZ = 0;

    public void a(Group group) {
        if (group != null) {
            this.kcY = group.group_count.intValue();
            this.kcZ = group.hide_recommend_group.intValue();
        }
    }
}
