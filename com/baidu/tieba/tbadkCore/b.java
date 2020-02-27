package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int kec = 0;
    private int ked = 0;

    public void a(Group group) {
        if (group != null) {
            this.kec = group.group_count.intValue();
            this.ked = group.hide_recommend_group.intValue();
        }
    }
}
