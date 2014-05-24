package com.baidu.tieba.model;

import com.baidu.tieba.switchs.features.BarDetailForDirSwitchStatic;
/* loaded from: classes.dex */
public class bd {
    private String a = BarDetailForDirSwitchStatic.BAR_DETAIL_DIR;
    private be b;

    public void a(String str) {
        this.a = str;
    }

    public void a(be beVar) {
        this.b = beVar;
    }

    public void a(String str, long j) {
        new bf(str, j, this.a, this.b).execute(new Integer[0]);
    }
}
