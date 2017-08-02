package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int gdA = 0;
    private int gdB = 0;

    public void a(Group group) {
        if (group != null) {
            this.gdA = group.group_count.intValue();
            this.gdB = group.hide_recommend_group.intValue();
        }
    }
}
