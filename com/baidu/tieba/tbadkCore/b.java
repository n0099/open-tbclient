package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int gdF = 0;
    private int gdG = 0;

    public void a(Group group) {
        if (group != null) {
            this.gdF = group.group_count.intValue();
            this.gdG = group.hide_recommend_group.intValue();
        }
    }
}
