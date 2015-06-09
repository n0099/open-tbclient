package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.Group;
/* loaded from: classes.dex */
public class b {

    /* renamed from: com  reason: collision with root package name */
    private int f127com = 0;
    private int con = 0;

    public int amn() {
        return this.f127com;
    }

    public int amo() {
        return this.con;
    }

    public void a(Group group) {
        if (group != null) {
            this.f127com = group.group_count.intValue();
            this.con = group.hide_recommend_group.intValue();
        }
    }
}
