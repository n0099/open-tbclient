package com.baidu.tieba.model;

import com.baidu.tieba.switchs.SwitchKey;
/* loaded from: classes.dex */
public class cj {

    /* renamed from: a  reason: collision with root package name */
    private String f2029a = SwitchKey.BAR_DETAIL_DIR;
    private ck b;

    public void a(String str) {
        this.f2029a = str;
    }

    public void a(ck ckVar) {
        this.b = ckVar;
    }

    public void a(String str, long j) {
        new cl(str, j, this.f2029a, this.b).execute(new Integer[0]);
    }
}
