package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int gfZ = 0;
    private int gga = 0;

    public void a(Group group) {
        if (group != null) {
            this.gfZ = group.group_count.intValue();
            this.gga = group.hide_recommend_group.intValue();
        }
    }
}
