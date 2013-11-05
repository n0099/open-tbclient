package com.baidu.tieba.model;

import com.baidu.tieba.switchs.SwitchKey;
/* loaded from: classes.dex */
public class cp {

    /* renamed from: a  reason: collision with root package name */
    private String f1942a = SwitchKey.BAR_DETAIL_DIR;
    private cq b;

    public void a(String str) {
        this.f1942a = str;
    }

    public void a(cq cqVar) {
        this.b = cqVar;
    }

    public void a(String str, long j) {
        new cr(str, j, this.f1942a, this.b).execute(new Integer[0]);
    }
}
