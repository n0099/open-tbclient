package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int jfZ = 0;
    private int jga = 0;

    public void a(Group group) {
        if (group != null) {
            this.jfZ = group.group_count.intValue();
            this.jga = group.hide_recommend_group.intValue();
        }
    }
}
