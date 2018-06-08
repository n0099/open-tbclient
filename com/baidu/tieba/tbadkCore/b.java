package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int gFJ = 0;
    private int gFK = 0;

    public void a(Group group) {
        if (group != null) {
            this.gFJ = group.group_count.intValue();
            this.gFK = group.hide_recommend_group.intValue();
        }
    }
}
