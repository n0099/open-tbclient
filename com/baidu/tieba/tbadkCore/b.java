package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int fza = 0;
    private int fzb = 0;

    public void a(Group group) {
        if (group != null) {
            this.fza = group.group_count.intValue();
            this.fzb = group.hide_recommend_group.intValue();
        }
    }
}
