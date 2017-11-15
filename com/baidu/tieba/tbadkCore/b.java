package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int gnf = 0;
    private int gng = 0;

    public void a(Group group) {
        if (group != null) {
            this.gnf = group.group_count.intValue();
            this.gng = group.hide_recommend_group.intValue();
        }
    }
}
