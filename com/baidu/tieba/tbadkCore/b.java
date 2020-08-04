package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int lKN = 0;
    private int lKO = 0;

    public void a(Group group) {
        if (group != null) {
            this.lKN = group.group_count.intValue();
            this.lKO = group.hide_recommend_group.intValue();
        }
    }
}
