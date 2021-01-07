package com.baidu.tieba.newfaceshop.facemake;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public class a {
    public AtomicBoolean lxa;

    public a(Boolean bool) {
        this.lxa = new AtomicBoolean(bool.booleanValue());
    }

    public void uk(boolean z) {
        this.lxa.set(z);
    }

    public boolean getResult() {
        return this.lxa.get();
    }
}
