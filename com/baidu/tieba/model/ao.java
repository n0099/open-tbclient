package com.baidu.tieba.model;

import com.baidu.tieba.data.InterestFrsData;
/* loaded from: classes.dex */
public final class ao extends com.baidu.adp.a.e {
    private static final String a = String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/s/gettaglist";
    private boolean b;
    private InterestFrsData c;
    private ap d;

    public final boolean a() {
        return this.b;
    }

    public final void a(boolean z) {
        this.b = z;
    }

    public final InterestFrsData b() {
        return this.c;
    }

    public final void a(InterestFrsData interestFrsData) {
        this.c = interestFrsData;
    }

    public final void a(int i, int i2, int i3, aq aqVar) {
        this.d = new ap(i, 0, 100, aqVar);
        this.d.execute(new Void[0]);
    }

    public final void c() {
        if (this.d != null) {
            this.d.cancel();
        }
    }

    @Override // com.baidu.adp.a.e
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.e
    public final boolean cancelLoadData() {
        return false;
    }
}
