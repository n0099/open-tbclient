package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int mcL = 0;
    private int mcM = 0;

    public void a(Group group) {
        if (group != null) {
            this.mcL = group.group_count.intValue();
            this.mcM = group.hide_recommend_group.intValue();
        }
    }
}
