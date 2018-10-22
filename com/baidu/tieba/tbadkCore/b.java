package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int gZx = 0;
    private int gZy = 0;

    public void a(Group group) {
        if (group != null) {
            this.gZx = group.group_count.intValue();
            this.gZy = group.hide_recommend_group.intValue();
        }
    }
}
