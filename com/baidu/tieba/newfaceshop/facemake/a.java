package com.baidu.tieba.newfaceshop.facemake;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public class a {
    public AtomicBoolean lsu;

    public a(Boolean bool) {
        this.lsu = new AtomicBoolean(bool.booleanValue());
    }

    public void ug(boolean z) {
        this.lsu.set(z);
    }

    public boolean getResult() {
        return this.lsu.get();
    }
}
