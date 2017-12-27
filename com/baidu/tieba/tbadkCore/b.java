package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int hfs = 0;
    private int hft = 0;

    public void a(Group group) {
        if (group != null) {
            this.hfs = group.group_count.intValue();
            this.hft = group.hide_recommend_group.intValue();
        }
    }
}
