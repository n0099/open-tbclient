package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int jfi = 0;
    private int jfj = 0;

    public void a(Group group) {
        if (group != null) {
            this.jfi = group.group_count.intValue();
            this.jfj = group.hide_recommend_group.intValue();
        }
    }
}
