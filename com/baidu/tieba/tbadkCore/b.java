package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int gZw = 0;
    private int gZx = 0;

    public void a(Group group) {
        if (group != null) {
            this.gZw = group.group_count.intValue();
            this.gZx = group.hide_recommend_group.intValue();
        }
    }
}
