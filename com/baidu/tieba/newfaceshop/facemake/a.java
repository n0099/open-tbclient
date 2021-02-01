package com.baidu.tieba.newfaceshop.facemake;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public class a {
    public AtomicBoolean lAz;

    public a(Boolean bool) {
        this.lAz = new AtomicBoolean(bool.booleanValue());
    }

    public void ut(boolean z) {
        this.lAz.set(z);
    }

    public boolean getResult() {
        return this.lAz.get();
    }
}
