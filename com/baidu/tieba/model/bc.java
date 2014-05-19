package com.baidu.tieba.model;

import com.baidu.tieba.switchs.features.BarDetailForDirSwitchStatic;
/* loaded from: classes.dex */
public class bc {
    private String a = BarDetailForDirSwitchStatic.BAR_DETAIL_DIR;
    private bd b;

    public void a(String str) {
        this.a = str;
    }

    public void a(bd bdVar) {
        this.b = bdVar;
    }

    public void a(String str, long j) {
        new be(str, j, this.a, this.b).execute(new Integer[0]);
    }
}
