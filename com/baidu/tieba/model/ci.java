package com.baidu.tieba.model;

import com.baidu.tieba.switchs.SwitchKey;
/* loaded from: classes.dex */
public class ci {
    private String a = SwitchKey.BAR_DETAIL_DIR;
    private cj b;

    public void a(String str) {
        this.a = str;
    }

    public void a(cj cjVar) {
        this.b = cjVar;
    }

    public void a(String str, long j) {
        new ck(str, j, this.a, this.b).execute(new Integer[0]);
    }
}
