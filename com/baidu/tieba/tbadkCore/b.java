package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int jcJ = 0;
    private int jcK = 0;

    public void a(Group group) {
        if (group != null) {
            this.jcJ = group.group_count.intValue();
            this.jcK = group.hide_recommend_group.intValue();
        }
    }
}
