package com.baidu.tieba.newfaceshop.facemake;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public class a {
    public AtomicBoolean lCP;

    public a(Boolean bool) {
        this.lCP = new AtomicBoolean(bool.booleanValue());
    }

    public void ut(boolean z) {
        this.lCP.set(z);
    }

    public boolean getResult() {
        return this.lCP.get();
    }
}
