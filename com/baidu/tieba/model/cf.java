package com.baidu.tieba.model;

import com.baidu.tieba.switchs.SwitchKey;
/* loaded from: classes.dex */
public class cf {

    /* renamed from: a  reason: collision with root package name */
    private String f1439a = SwitchKey.BAR_DETAIL_DIR;
    private cg b;

    public void a(String str) {
        this.f1439a = str;
    }

    public void a(cg cgVar) {
        this.b = cgVar;
    }

    public void a(String str, long j) {
        new ch(str, j, this.f1439a, this.b).execute(new Integer[0]);
    }
}
