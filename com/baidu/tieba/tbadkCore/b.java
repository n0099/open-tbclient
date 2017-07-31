package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int geL = 0;
    private int geM = 0;

    public void a(Group group) {
        if (group != null) {
            this.geL = group.group_count.intValue();
            this.geM = group.hide_recommend_group.intValue();
        }
    }
}
