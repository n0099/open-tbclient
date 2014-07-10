package com.baidu.tieba.model;

import com.baidu.tieba.switchs.features.BarDetailForDirSwitchStatic;
/* loaded from: classes.dex */
public class be {
    private String a = BarDetailForDirSwitchStatic.BAR_DETAIL_DIR;
    private bf b;

    public void a(String str) {
        this.a = str;
    }

    public void a(bf bfVar) {
        this.b = bfVar;
    }

    public void a(String str, long j) {
        new bg(str, j, this.a, this.b).execute(new Integer[0]);
    }
}
