package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int jZv = 0;
    private int jZw = 0;

    public void a(Group group) {
        if (group != null) {
            this.jZv = group.group_count.intValue();
            this.jZw = group.hide_recommend_group.intValue();
        }
    }
}
