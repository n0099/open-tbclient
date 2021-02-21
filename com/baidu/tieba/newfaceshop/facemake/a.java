package com.baidu.tieba.newfaceshop.facemake;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public class a {
    public AtomicBoolean lAN;

    public a(Boolean bool) {
        this.lAN = new AtomicBoolean(bool.booleanValue());
    }

    public void ut(boolean z) {
        this.lAN.set(z);
    }

    public boolean getResult() {
        return this.lAN.get();
    }
}
