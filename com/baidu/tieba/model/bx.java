package com.baidu.tieba.model;

import com.baidu.tieba.switchs.SwitchKey;
/* loaded from: classes.dex */
public class bx {
    private String a = SwitchKey.BAR_DETAIL_DIR;
    private by b;

    public void a(String str) {
        this.a = str;
    }

    public void a(by byVar) {
        this.b = byVar;
    }

    public void a(String str, long j) {
        new bz(str, j, this.a, this.b).execute(new Integer[0]);
    }
}
