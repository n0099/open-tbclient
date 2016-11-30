package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int fzk = 0;
    private int fzl = 0;

    public int bkc() {
        return this.fzl;
    }

    public void a(Group group) {
        if (group != null) {
            this.fzk = group.group_count.intValue();
            this.fzl = group.hide_recommend_group.intValue();
        }
    }
}
