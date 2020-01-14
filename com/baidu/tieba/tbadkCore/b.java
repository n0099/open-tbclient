package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int kdd = 0;
    private int kde = 0;

    public void a(Group group) {
        if (group != null) {
            this.kdd = group.group_count.intValue();
            this.kde = group.hide_recommend_group.intValue();
        }
    }
}
