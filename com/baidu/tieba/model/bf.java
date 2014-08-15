package com.baidu.tieba.model;

import com.baidu.tieba.switchs.features.BarDetailForDirSwitchStatic;
/* loaded from: classes.dex */
public class bf {
    private String a = BarDetailForDirSwitchStatic.BAR_DETAIL_DIR;
    private bg b;

    public void a(String str) {
        this.a = str;
    }

    public void a(bg bgVar) {
        this.b = bgVar;
    }

    public void a(String str, long j) {
        new bh(str, j, this.a, this.b).execute(new Integer[0]);
    }
}
