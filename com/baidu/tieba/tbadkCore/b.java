package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int hmd = 0;
    private int hme = 0;

    public void a(Group group) {
        if (group != null) {
            this.hmd = group.group_count.intValue();
            this.hme = group.hide_recommend_group.intValue();
        }
    }
}
