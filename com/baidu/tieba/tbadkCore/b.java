package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int gmd = 0;
    private int gme = 0;

    public void a(Group group) {
        if (group != null) {
            this.gmd = group.group_count.intValue();
            this.gme = group.hide_recommend_group.intValue();
        }
    }
}
