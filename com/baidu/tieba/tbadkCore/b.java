package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int mBN = 0;
    private int mBO = 0;

    public void a(Group group) {
        if (group != null) {
            this.mBN = group.group_count.intValue();
            this.mBO = group.hide_recommend_group.intValue();
        }
    }
}
