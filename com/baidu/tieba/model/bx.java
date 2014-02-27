package com.baidu.tieba.model;

import com.baidu.tieba.switchs.SwitchKey;
/* loaded from: classes.dex */
public final class bx {
    private String a = SwitchKey.BAR_DETAIL_DIR;
    private by b;

    public final void a(String str) {
        this.a = str;
    }

    public final void a(by byVar) {
        this.b = byVar;
    }

    public final void a(String str, long j) {
        new bz(str, j, this.a, this.b).execute(new Integer[0]);
    }
}
