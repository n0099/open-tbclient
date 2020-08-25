package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes2.dex */
public class b {
    private int mcw = 0;
    private int mcx = 0;

    public void a(Group group) {
        if (group != null) {
            this.mcw = group.group_count.intValue();
            this.mcx = group.hide_recommend_group.intValue();
        }
    }
}
