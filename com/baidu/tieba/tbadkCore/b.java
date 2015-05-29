package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {
    private int col = 0;

    /* renamed from: com  reason: collision with root package name */
    private int f127com = 0;

    public int amm() {
        return this.col;
    }

    public int amn() {
        return this.f127com;
    }

    public void a(Group group) {
        if (group != null) {
            this.col = group.group_count.intValue();
            this.f127com = group.hide_recommend_group.intValue();
        }
    }
}
