package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int gdG = 0;
    private int gdH = 0;

    public void a(Group group) {
        if (group != null) {
            this.gdG = group.group_count.intValue();
            this.gdH = group.hide_recommend_group.intValue();
        }
    }
}
