package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int frd = 0;
    private int fre = 0;

    public int bfs() {
        return this.fre;
    }

    public void a(Group group) {
        if (group != null) {
            this.frd = group.group_count.intValue();
            this.fre = group.hide_recommend_group.intValue();
        }
    }
}
