package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int fJe = 0;
    private int fJf = 0;

    public void a(Group group) {
        if (group != null) {
            this.fJe = group.group_count.intValue();
            this.fJf = group.hide_recommend_group.intValue();
        }
    }
}
