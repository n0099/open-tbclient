package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int gul = 0;
    private int gum = 0;

    public void a(Group group) {
        if (group != null) {
            this.gul = group.group_count.intValue();
            this.gum = group.hide_recommend_group.intValue();
        }
    }
}
